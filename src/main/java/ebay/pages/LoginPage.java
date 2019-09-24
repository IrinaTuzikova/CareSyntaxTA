package ebay.pages;

import com.epam.jdi.light.elements.composite.WebPage;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.Link;
import ebay.sections.LoginForm;

public class LoginPage extends WebPage {

    @Css("#InLineCreateAnAccount")
    public Link createAnAccountLink;

    @Css(".signin-view-container")
    public LoginForm loginForm;

    @Css("#sgnBt")
    public Button signInBtn;
}
