package com.ehealth.doctors.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ehealth.doctors.model.entity.CustomUser;


@RestController
@RequestMapping("/home")
public class HomeController {

	@RequestMapping(value = "/secured/home", method = RequestMethod.GET)
	@Secured ({"ROLE_USER", "ROLE_ADMIN"})
	public String securedHome(ModelMap model) {
		boolean auth = SecurityContextHolder.getContext()
		.getAuthentication().isAuthenticated();
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		CustomUser user = null;
		if (principal instanceof CustomUser) {
			user = ((CustomUser) principal);
		}
		WebAuthenticationDetails det = (WebAuthenticationDetails) SecurityContextHolder
				.getContext().getAuthentication().getDetails();
		String ssoId = user.getSsoId();

		String name = user.getUsername();
		model.addAttribute("username", name);
		model.addAttribute("message", "Welcome to the secured page");
		return "secured/home";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request,
			HttpServletResponse response, HttpSession session) {
		response.setStatus(303);
		
	    SecurityContextHolder.clearContext();
	    session = request.getSession(false);
	        if(session != null) {
	        	session.invalidate();
	        }
	        for(Cookie cookie : request.getCookies()) {
	            cookie.setMaxAge(0);
	        }


		return "logout";
	}

}