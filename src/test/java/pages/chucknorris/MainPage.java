package pages.chucknorris;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MainPage {

    private static final String URL = "https://api.icndb.com";
    private static final String FIRST_LAST_NAME = "jokes/random?firstName=%s&lastName=%s";
    private static final String RANDOM_JOKE = "jokes/random";


    private RequestSpecification chuckSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(URL)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();
    }

    private ExtractableResponse<Response> extractableResponse(String url) {
        return RestAssured
                .given()
                .spec(chuckSpecification())
                .when()
                .get(url)
                .then()
                .extract();
    }

    private String urlSetter(String firstName, String lastName) {
        return String.format(FIRST_LAST_NAME, firstName, lastName);
    }

    private String urlSetter(String url) {
        return url;
    }

    public String getJokeWithRandomName(String fistName, String lastName) {
        return extractableResponse(urlSetter(fistName, lastName)).body().asPrettyString();
    }

    public int getStatusResponse(ExtractableResponse<Response> response) {
        return response.statusCode();
    }

    public String getRandomJoke() {
        return extractableResponse(urlSetter(RANDOM_JOKE)).body().asPrettyString();
    }
}