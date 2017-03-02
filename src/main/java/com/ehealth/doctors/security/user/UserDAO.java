package com.ehealth.doctors.security.user;

import java.util.ArrayList;
import java.util.List;

import com.ehealth.doctors.model.entity.Role;
import com.ehealth.doctors.model.entity.User;

public class UserDAO {

	
	public User loadUserByUsername(final String username) {
		//db
        User user = new User();
        user.setFirstName("firstName");
        user.setLastName("lastName");
        user.setUsername("user");
        user.setPassword("1111");
        Role r = new Role();
        r.setName("ROLE_USER");
        List<Role> roles = new ArrayList<Role>();
        roles.add(r);
        user.setAuthorities(roles);
        return user;
    }
}
