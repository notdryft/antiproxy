package org.dryft.antiproxy.services;

import org.dryft.antiproxy.annotations.Role;

public interface UserService {

    @Role("manager")
    void addUser(String user, String address, boolean admin);
}
