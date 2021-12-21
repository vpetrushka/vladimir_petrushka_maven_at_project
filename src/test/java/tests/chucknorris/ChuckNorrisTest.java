package tests.chucknorris;


import org.junit.Test;
import pages.chucknorris.MainPage;

public class ChuckNorrisTest {

    MainPage mainPage = new MainPage();

    @Test
    public void randomNameTest(){
        mainPage.getJokeWithRandomName("Vasia","Pupkin");
    }

    @Test
    public void randomJokeTest(){
        mainPage.getRandomJoke();
    }

}
