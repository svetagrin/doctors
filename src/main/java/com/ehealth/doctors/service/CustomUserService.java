package com.ehealth.doctors.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ehealth.doctors.model.entity.CustomUser;
import com.ehealth.doctors.security.user.UserDAOImpl;


@Service
public class CustomUserService implements UserDetailsService {

	 @Autowired
	 private UserDAOImpl userDao;
	 
	 
	public CustomUser loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.loadUserByUsername(username);
	}

}
