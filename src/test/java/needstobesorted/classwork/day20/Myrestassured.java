package needstobesorted.classwork.day20;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Myrestassured {

    public static void main(String[] args) {

        RequestSpecification requestSpecification= new RequestSpecBuilder()
                .setBaseUri("https://api.icndb.com")
          //      .setPort(8080)
                .setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON)
                .log(LogDetail.ALL)
                .build();

        String result = RestAssured
                .given()
                .spec(requestSpecification)
          //      .body("")
                .when()
                .get("jokes/random?firstName=John&lastName=Doe")
                .then()
                .extract().body().asPrettyString();
        // .extract().body().as(Search.class).equals(BaseSteps.getUser(name));

        System.out.println(result);
    }
}
