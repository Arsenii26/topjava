package ru.javawebinar.topjava.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import ru.javawebinar.topjava.AuthorizedUser;

import static java.util.Objects.requireNonNull;

public class SecurityUtil {

    private SecurityUtil() {
    }

    public static AuthorizedUser safeGet() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }

        //The API of the Authentication class is very open so that the framework remains as flexible as possible.
        //
        // Because of this, the Spring Security principal can only be retrieved as an Object and needs to be cast to the correct UserDetails instance:
        Object principal = auth.getPrincipal();
        return (principal instanceof AuthorizedUser) ? (AuthorizedUser) principal : null;
    }

    public static AuthorizedUser get() {
        AuthorizedUser user = safeGet();
        requireNonNull(user, "No authorized user found");
        return user;
    }

    public static int authUserId() {
        return get().getUserTo().id();
    }

    public static int authUserCaloriesPerDay() {
        return get().getUserTo().getCaloriesPerDay();
    }
}