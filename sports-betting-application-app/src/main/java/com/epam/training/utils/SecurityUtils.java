package com.epam.training.utils;

import com.epam.training.model.user.CurrentProfile;
import com.epam.training.model.user.UserAbstract;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Get information about the current user from the session.
 */
public class SecurityUtils {

    public static CurrentProfile getCurrentProfile() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null) {
            return null;
        }

        final Object principal = authentication.getPrincipal();

        if (principal instanceof UserAbstract) {
            final Integer id = ((UserAbstract) principal).getId();
            final String email = ((UserAbstract) principal).getEmail();
            return new CurrentProfile(id, email);
        }
        return null;
    }

}
