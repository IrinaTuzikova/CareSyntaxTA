package qvident.entities;

import com.epam.jdi.tools.DataClass;

public class User extends DataClass<User> {

    public String login;
    public String password;

    public String getEmail() {
        return login;
    }

    public void setEmail(String email) {
        this.login = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String print() {
        return "User Info {" +
                "LOGIN = " + login +
                ", PASSWORD = " + password +
                '}';
    }

}

