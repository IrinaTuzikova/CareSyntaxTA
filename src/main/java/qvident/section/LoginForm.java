package qvident.section;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.XPath;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import qvident.entities.User;

public class LoginForm extends Form<User> {

    @XPath("//input[@placeholder='Username']")
    public TextField login;

    @XPath("//input[@placeholder='Password']")
    public TextField password;

    @XPath("//button[@type='submit']")
    public Button signInButton;
}
