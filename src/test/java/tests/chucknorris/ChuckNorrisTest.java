package tests.chucknorris;

import org.junit.Test;
import pages.chucknorris.MainPage;

import static org.hamcrest.Matchers.*;

public class ChuckNorrisTest {

    MainPage mainPage = new MainPage();

    @Test
    public void randomNameContentTypeTest() {
        mainPage.getJokeWithRandomName("Vasia", "Pupkin").assertThat().header("Content-Type", "application/json");
    }

    @Test
    public void randomNameValue(){
        mainPage.getJokeWithRandomName("Vasia", "Pupkin").body("type",equalTo("success"));
    }

    @Test
    public void randomNameJokeContainsName(){
        mainPage.getJokeWithRandomName("Vasia","Pupkin").body("value.joke",containsString("Vasia"));
    }

    @Test
    public void randomJokeTest() {
        mainPage.getRandomJoke().extract().body().asPrettyString();
    }

}