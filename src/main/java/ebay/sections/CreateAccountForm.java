package ebay.sections;

import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import ebay.entities.User;

public class CreateAccountForm extends Form<User> {
    @Css("#firstname")
    public TextField firstName;

    @Css("#lastname")
    public TextField lastName;

    @Css("#email")
    public TextField email;

    @Css("#PASSWORD")
    public TextField password;

    @Css("#ppaFormSbtBtn")
    public Button registerButton;

}
