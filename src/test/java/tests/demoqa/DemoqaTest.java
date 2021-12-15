package tests.demoqa;

import org.junit.Test;
import pages.demoqa.SelectMenuPage;

import static pages.demoqa.SelectMenuPage.*;

public class DemoqaTest {

    SelectMenuPage menuPage = new SelectMenuPage();

    @Test
    public void selectDemoQaTest() {

        menuPage.navigateToPage();
        menuPage.getMenu(WITH_OPT_MENU);
        menuPage.setMenu("Group 1, option 2");
        menuPage.getMenu(SELECT_ONE_MENU);
        menuPage.setMenu("Mr.");
        menuPage.setAlternativeMenu(OLD_STYLE_MENU, "9");
        menuPage.getMenu(MULTI_SELECT_DROPDOWN);
        menuPage.setMenu("Black");
        menuPage.setAlternativeMenu(STANDARD_MULTI_MENU, "opel");
    }
}
