package com.ericknunes.utils;

import com.ericknunes.backend.persistence.domain.backend.User;

public class UsersUtils {

    /**
     * Non instantiable.
     */
    private UsersUtils() { throw new  AssertionError("Non instantiable"); }

    /**
     * Creates a user with basic atributes set.
     * @return A user entity
     */
    public static User createBasicUser()
    {
        User user = new User();
        user.setUsername("basicUser");
        user.setPassword("secret");
        user.setEmail("me@example.com");
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setPhoneNumber("123456789123");
        user.setCountry("BR");
        user.setEnable(true);
        user.setDescription("A basic User");
        user.setProfileImageUrl("https://blabla.images.com/basicuser");

        return user;
    }
}
