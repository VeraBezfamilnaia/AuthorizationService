package com.bezf.authorizationservice.services;

import com.bezf.authorizationservice.Authorities;
import com.bezf.authorizationservice.exceptions.InvalidCredentials;
import com.bezf.authorizationservice.exceptions.UnauthorizedUser;
import com.bezf.authorizationservice.dao.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AuthorizationService {
    private final UserDAO UserDAO;

    @Autowired
    public AuthorizationService(UserDAO UserDAO) {
        this.UserDAO = UserDAO;
    }

    public List<Authorities> getAuthorities(String user, String password) {
        if (isEmpty(user) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }

        List<Authorities> userRights = UserDAO.getUserRights(user, password);
        if (isEmpty(userRights)) {
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userRights;
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }
}
