package org.dryft.antiproxy;

import org.dryft.antiproxy.annotations.Role;
import org.dryft.antiproxy.core.Container;
import org.dryft.antiproxy.services.UserService;
import org.dryft.antiproxy.services.impl.UserServiceImpl;

import java.lang.reflect.AnnotatedElement;

public class Main {

    private static void checkRole(AnnotatedElement element, Role role) {
        // Do nothing
    }

    public static void main(String[] args) {
        Container container = new Container();
        container.addAdvice((element, receiver, arguments, adviceContext) -> {
            Role role = element.getAnnotation(Role.class);
            if (role != null) {
                checkRole(element, role);
            }

            return adviceContext.call(element, receiver, arguments);
        });

        UserService userService = container.getService(UserService.class, UserServiceImpl.class);
        for (int i = 0; i < 1_000_000; i++) {
            userService.addUser("Sherlock Holmes", "221b Baker Street", true);
        }
    }
}
