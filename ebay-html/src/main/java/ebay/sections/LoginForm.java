package ebay.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ebay.entities.User;

public class LoginForm extends Form<User> {

    @Css("#userid") public TextField email;
    @Css("#pass") public TextField password;

    @Css("#sgnBt") public Button signInButton;
}
