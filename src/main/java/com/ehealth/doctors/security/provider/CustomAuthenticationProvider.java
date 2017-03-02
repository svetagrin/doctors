package com.ehealth.doctors.security.provider;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ehealth.doctors.service.CustomUserService;
import com.ehealth.doctors.model.entity.CustomUser;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private CustomUserService userService;

	public Authentication authenticate(Authentication authentication)
			throws AuthenticationException {
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder
				.currentRequestAttributes();
		String sid = attributes.getSessionId();
		if (SecurityContextHolder.getContext().getAuthentication() != null
				&& SecurityContextHolder.getContext().getAuthentication()
						.isAuthenticated()) {
			return SecurityContextHolder.getContext().getAuthentication();
		}
		String username = authentication.getName();
		String password = (String) authentication.getCredentials();
		WebAuthenticationDetails det = new WebAuthenticationDetails(
				attributes.getRequest());

		CustomUser user = userService.loadUserByUsername(username);

		if (user == null || !user.getUsername().equalsIgnoreCase(username)) {
			throw new BadCredentialsException("Username not found.");
		}

		if (!password.equals(user.getPassword())) {
			throw new BadCredentialsException("Wrong password.");
		}

		user.setSsoId(sid);
		Collection<? extends GrantedAuthority> authorities = user
				.getAuthorities();
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
				user, password, authorities);
		token.setDetails(det);
		SecurityContextHolder.getContext().setAuthentication(token);
		return token;
	}

	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
