package qvident;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import qvident.pages.DashboardPage;
import qvident.pages.LoginPage;

public class QvidentSite {

    @Url("/login") @Title("caresyntax - qvident")
    public static LoginPage loginPage;

    @Url("/redesign/dashboard") @Title("Qvident")
    public static DashboardPage dashboardPage;



}
