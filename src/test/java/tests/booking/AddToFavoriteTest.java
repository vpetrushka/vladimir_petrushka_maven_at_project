package tests.booking;

import org.junit.Test;
import pages.booking.CreateAccountLogin;
import pages.booking.MainPage;
import pages.trashmail.AddressManagerPage;

public class AddToFavoriteTest {

    MainPage mainPage = new MainPage();
    CreateAccountLogin login = new CreateAccountLogin();
    AddressManagerPage page = new AddressManagerPage();
    pages.trashmail.MainPage mail = new pages.trashmail.MainPage();

    @Test
    public void addToFavoriteTest(){
        mainPage.navigateToMainPage();
        mainPage.clickSignIn();
        login.inputEmail();

    }
}
