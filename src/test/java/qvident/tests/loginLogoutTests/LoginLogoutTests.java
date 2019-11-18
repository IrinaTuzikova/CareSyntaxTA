package qvident.tests.loginLogoutTests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import qvident.QvidentTestsInit;
import qvident.data.Users;
import qvident.entities.User;
import qvident.helpers.WaitingHelper;
import qvident.listeners.OnFailListener;
import qvident.section.LoginForm;

import static qvident.QvidentSite.dashboardPage;
import static qvident.QvidentSite.loginPage;

@Listeners(OnFailListener.class)
public class LoginLogoutTests extends QvidentTestsInit {

    @Test(groups = "func")
    @Features(@Feature("Login"))
    @Stories(@Story("Login"))
    public void loginAsPresentUserAndVerifyLoginTest() {
        loginAsUser(Users.admin);
        dashboardPage.checkOpened();
    }

    @Test(groups = "func")
    @Features(@Feature("Login"))
    @Stories(@Story("Logout"))
    public void checkLogoutAfterLoginAsPresentUserTest() {
        loginAsUser(Users.admin);
        dashboardPage.checkOpened();
    }

    @Step
    public void loginAsUser(User user) {
        loginPage.open();
        WaitingHelper.waitAllRequestsOnPage();
        LoginForm loginForm = loginPage.loginForm;
        loginForm.fill(user);
        loginForm.submit();
        loginForm.waitFor().disappear();
    }


}
