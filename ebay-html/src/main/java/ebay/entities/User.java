package ebay.entities;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {
    public String firstName, lastName, email, password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public String print() {
        return "User Info {" +
                "FIRST_NAME = " + firstName +
                ", LAST_NAME = " + lastName +
                ", EMAIL = " + email +
                ", PASSWORD = " + password +
                '}';
    }

}

