package qvident;

import com.epam.jdi.light.elements.pageobjects.annotations.Title;
import com.epam.jdi.light.elements.pageobjects.annotations.Url;
import qvident.pages.LoginPage;

public class QvidentSite {

    @Url("/login") @Title("")
    public static LoginPage loginPage;

}
