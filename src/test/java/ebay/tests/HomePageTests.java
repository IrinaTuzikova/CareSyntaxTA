package ebay.tests;

import ebay.EbayTestsInit;
import ebay.entities.User;
import ebay.helpers.WaitingHelper;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Stories;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import static com.epam.jdi.light.settings.WebSettings.logger;

import static ebay.EbaySite.*;
import static ebay.helpers.WaitingHelper.waitAllRequestsOnPage;

public class HomePageTests  extends EbayTestsInit {

   public String EMAIL_FOR_LOGIN = "AUTEmail@gmail.com";
   public String PASSWORD_FOR_LOGIN = "AUT-fls";
   public String SEARCHED_ITEM = "Intel NUC";
   public String totalAmount = "";
   public String userId = "";

    @Test(groups = "func")
    @Features(@Feature( "Login"))
    @Stories(@Story("Login"))
    public void searchAndCaptureIntelNUC() {
        navigationThroughSite.goToLoginPageFromHomePage();
        User userForLogin = new User(EMAIL_FOR_LOGIN, PASSWORD_FOR_LOGIN);
        loginPage.loginForm.fillLoginForm(userForLogin);
        loginPage.signInBtn.click();
        waitAllRequestsOnPage();
        homePage.checkOpened();
        userId = homePage.userIdText.getValue();
        homePage.searchField.input(SEARCHED_ITEM);
        homePage.searchBtn.click();
        waitAllRequestsOnPage();
        searchResultPage.checkOpened();
        totalAmount = searchResultPage.totalAmountOfFoundItems.getValue();
        searchResultPage.buyItNowLink.click();
        searchResultPage.sizeOfMemory8GB.check();
        searchResultPage.conditionNew.check();
        searchResultPage.scrollToTop();
        waitAllRequestsOnPage();
        searchResultPage.sortDropdown.select(searchResultPage.TYPE_OF_SORT);
        searchResultPage.lowestPrice = searchResultPage.cheapestItemCellPrice.getValue();
        logger.toLog("Total number: " + totalAmount);
        logger.toLog("Lowest price: " + searchResultPage.lowestPrice);
        logger.toLog("User ID: " + userId);

    }


}
