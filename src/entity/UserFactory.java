package entity;

import entity.Users.User;
import entity.Users.Wibu;

public class UserFactory {
    public UserFactory() {
    }

    public static User createUser(String typeUser, String user, String password, String name, String email) {
        switch (typeUser) {
            case "WIBU":
                return new Wibu(user, password, name, email);
            default:
                return null;
        }
    }
}
