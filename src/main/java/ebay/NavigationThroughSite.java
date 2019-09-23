package ebay;

import com.epam.jdi.light.elements.composite.WebPage;
import io.qameta.allure.Step;

import static ebay.EbaySite.*;

/*
 * Use 'go' prefix for the methods when navigation from the page to page (form, popup)
 * and 'come' prefix when have all the steps from the login
 * */

public class NavigationThroughSite extends WebPage {

    @Step
    public void goToLoginPageFromHomePage(){
        homePage.checkOpened();
        homePage.myEbayButton.click();
        loginPage.checkOpened();
    }

    @Step
    public void goToCreateAccountPageFromLoginPage(){
        loginPage.checkOpened();
        loginPage.createAnAccountLink.click();
        createAccountPage.checkOpened();
    }

}
