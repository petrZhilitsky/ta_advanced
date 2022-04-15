package com.epam.gomel.taf.framework.factory;

import com.epam.gomel.taf.framework.bo.User;

public class UserFactory {
    public static User defaultUser() {
        User user = new User();
        user.setLogin(Configuration.USER_LOGIN);
        user.setPassword(Configuration.USER_PASSWORD);
        return user;
    }

    public static User wrongUser() {
        User user = new User();
        user.setLogin(Configuration.USER_LOGIN);
        user.setPassword(Configuration.ADMIN_PASSWORD);
        return user;
    }

    public static User admin() {
        User user = new User();
        user.setLogin(Configuration.ADMIN_LOGIN);
        user.setPassword(Configuration.ADMIN_PASSWORD);
        return user;
    }
}
