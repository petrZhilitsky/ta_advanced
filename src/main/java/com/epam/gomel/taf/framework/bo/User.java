package com.epam.gomel.taf.framework.bo;

import com.epam.gomel.taf.framework.factory.Constants;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class User {
    private String login;
    private String password;

    public User() {
        setLogin(Constants.USER_LOGIN);
        setPassword(Constants.USER_PASSWORD);
    }
}
