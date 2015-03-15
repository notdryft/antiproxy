package org.dryft.antiproxy.services.impl;

import org.dryft.antiproxy.services.UserService;

public class UserServiceImpl implements UserService {

    private static int COUNTER = 0;

    @Override
    public void addUser(String user, String address, boolean admin) {
        COUNTER++;
    }
}
