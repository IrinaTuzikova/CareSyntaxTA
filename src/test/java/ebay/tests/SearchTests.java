package ebay.tests;

import ebay.EbayTestsInit;
import ebay.entities.User;
import ebay.generator.UserGenerator;
import ebay.listeners.OnFailListener;
import ebay.sections.CreateAccountForm;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static ebay.EbaySite.*;
import static ebay.helpers.WaitingHelper.waitAllRequestsOnPage;

@Listeners(OnFailListener.class)
public class SearchTests extends EbayTestsInit {

    public String SEARCHED_ITEM = "Intel NUC";
    public String TYPE_OF_SORT = "Lowest price";
    public String totalAmount = "";
    public String userId = "";
    public String lowestPriceValue = "";

    @Test(groups = "func")
    @Features(@Feature("Login"))
    @Stories(@Story("Login"))
    public void searchAndCaptureIntelNUC() {
        createNewUserAndReturnIt();
        summaryPage.checkOpened();
        userId = summaryPage.userId.getValue();
        homePage.shouldBeOpened();
        searchByValue(SEARCHED_ITEM);
        searchResultPage.checkOpened();
        totalAmount = searchResultPage.totalAmountOfFoundItems.getValue();
        searchResultPage.buyItNowLink.click();
        searchResultPage.sizeOfMemory8GB.check();
        searchResultPage.conditionNew.check();
        searchResultPage.scrollToTop();
        waitAllRequestsOnPage();
        searchResultPage.sortDropdown.select(TYPE_OF_SORT);
        lowestPriceValue = searchResultPage.cheapestItemCellPrice.getValue();
        logger.toLog("Total number: " + totalAmount);
        logger.toLog("Lowest price: " + lowestPriceValue);
        logger.toLog("User ID: " + userId);
    }


    @Step
    public User createNewUserAndReturnIt(){
        navigationThroughSite.goToLoginPageFromHomePage();
        navigationThroughSite.goToCreateAccountPageFromLoginPage();
        User randomGeneratedUser = UserGenerator.randomGeneratedUser;
        CreateAccountForm createAccountForm = createAccountPage.createAccountForm;
        createAccountForm.fill(randomGeneratedUser);
        createAccountForm.submit();
        logger.toLog("[AUT_INFO] Just created User is :: " + randomGeneratedUser.print());
        return randomGeneratedUser;
    }

    @Step
    public void loginAsAlreadyCreatedUser(String login, String password){
        navigationThroughSite.goToLoginPageFromHomePage();
        User userForLogin = new User(login, password);
        loginPage.loginForm.fillLoginForm(userForLogin);
        loginPage.signInBtn.click();
        waitAllRequestsOnPage();
    }

    @Step
    public void searchByValue(String value) {
        homePage.searchField.input(value);
        homePage.searchBtn.click();
        waitAllRequestsOnPage();
    }
}