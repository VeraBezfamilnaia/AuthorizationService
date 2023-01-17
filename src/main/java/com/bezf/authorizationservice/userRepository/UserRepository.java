package com.bezf.authorizationservice.userRepository;

import com.bezf.authorizationservice.Authorities;
import com.bezf.authorizationservice.model.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserRepository {
    private static final List<User> users;

    static {
        users = Arrays.asList(
                new User("Ivanov", "ivanov123", Arrays.asList(Authorities.DELETE, Authorities.WRITE)),
                new User("Petrov", "petrov123", Arrays.asList(Authorities.DELETE, Authorities.READ, Authorities.WRITE)),
                new User("Sidorov", "sidorov123", Arrays.asList(Authorities.DELETE, Authorities.READ))
        );
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        var authorities = new ArrayList<Authorities>();

        for (User currUser : users) {
            var currName = currUser.name();
            var currPassword = currUser.password();

            if (currName.equals(user) && currPassword.equals(password)) {
                authorities.addAll(currUser.authorities());
            }
        }
        return authorities;
    }
}

