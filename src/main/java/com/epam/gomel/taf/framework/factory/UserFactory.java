package com.epam.gomel.taf.framework.factory;

import com.epam.gomel.taf.framework.bo.User;

public class UserFactory {
    public static User defaultUser() {
        User user = new User();
        user.setLogin(Constants.USER_LOGIN);
        user.setPassword(Constants.USER_PASSWORD);
        return user;
    }

    public static User wrongUser() {
        User user = new User();
        user.setLogin(Constants.USER_LOGIN);
        user.setPassword(Constants.ADMIN_PASSWORD);
        return user;
    }

    public static User admin() {
        User user = new User();
        user.setLogin(Constants.ADMIN_LOGIN);
        user.setPassword(Constants.ADMIN_PASSWORD);
        return user;
    }
}
