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
    public void randomNameValueTest(){
        mainPage.getJokeWithRandomName("Vasia", "Pupkin").body("type",equalTo("success"));
    }

    @Test
    public void randomNameJokeContainsFirstNameTest(){
        mainPage.getJokeWithRandomName("Vasia","Pupkin").body("value.joke",containsString("Vasia"));
    }

    @Test
    public void randomNameJokeContainsLastNameTest(){
        mainPage.getJokeWithRandomName("Vasia","Pupkin").body("value.joke",containsString("Pupkin"));
    }

    @Test
    public void randomJokeNameTest() {
        mainPage.getRandomJoke().body("value.joke",containsString("Chuck"));
    }

    @Test
    public void randomJokeIdTest() {
        mainPage.getRandomJoke().body("value.id",isA(Integer.class));
    }

    @Test
    public void randomJokeCategoriesTest() {
        mainPage.getRandomJoke().assertThat().header("Content-Type", "application/json");
    }

    @Test
    public void randomMultipleJokesCountTest() {
        mainPage.getMultipleRandomJokes(4).body("value", hasSize(4));
    }

    @Test
    public void randomMultipleJokesLastJokeNameTest(){
        mainPage.getMultipleRandomJokes(4).body("value.joke",hasToString(containsString("Chuck")));
    }

    @Test
    public void randomMultipleJokesIdCountTest(){
        mainPage.getMultipleRandomJokes(4).body("value.id",hasSize(4));
    }

    @Test
    public void getSpecificJokeIdTest(){
        mainPage.getSpecificJoke(501).body("value.id",is(501));
    }

    @Test
    public void getSpecificJokeNameTest(){
        mainPage.getSpecificJoke(501).body("value.joke",containsString("Chuck"));
    }

    @Test
    public void getSpecificJokeCategoryTest(){
        mainPage.getSpecificJoke(501).body("value.categories",hasToString(containsString("nerdy")));
    }

    @Test
    public void getNumberOfJokesCountTest(){
        mainPage.getNumberOfJokes().body("value",is(574));
    }

    @Test
    public void getNumberOfJokesValueTypeOfValueTest(){
        mainPage.getNumberOfJokes().body("value",isA(Integer.class));
    }

    @Test
    public void getNumberOfJokesValueTypeTest(){
        mainPage.getNumberOfJokes().body("type",isA(String.class));
    }

}