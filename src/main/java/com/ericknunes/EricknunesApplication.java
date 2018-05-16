package com.ericknunes;

import com.ericknunes.backend.persistence.domain.backend.Role;
import com.ericknunes.backend.persistence.domain.backend.User;
import com.ericknunes.backend.persistence.domain.backend.UserRole;
import com.ericknunes.backend.service.UserService;
import com.ericknunes.enums.PlansEnum;
import com.ericknunes.enums.RolesEnum;
import com.ericknunes.utils.UsersUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class EricknunesApplication implements CommandLineRunner {

    private static final Logger LOG = LoggerFactory.getLogger(EricknunesApplication.class);

    @Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(EricknunesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

        User user = UsersUtils.createBasicUser();
        Set<UserRole> userRoles = new HashSet<>();
        userRoles.add(new UserRole(user, new Role(RolesEnum.BASIC)));
        LOG.debug("Creating user with username {}", user.getUsername());
        userService.createUser(user, PlansEnum.PRO, userRoles);
        LOG.info("User {} created", user.getUsername());

	}
}
