package com.shapeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shapeshop.model.AuthenticationRequest;
import com.shapeshop.model.AuthenticationResponse;
import com.shapeshop.service.UserService;
import com.shapeshop.util.JwtUtil;
import com.shapeshop.util.PasswordUtils;

@RestController
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	private UserService userDetailsService;

	@Autowired
	private PasswordUtils passwordValidationService;

	@CrossOrigin
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> loginAndCreateAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		Authentication authentication = null;

		String pswd = authenticationRequest.getPassword();
		String uName = authenticationRequest.getUsername();
		String encryptedPswd = passwordValidationService.encryptPassword(pswd);

		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

		authentication = authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(uName, encryptedPswd, userDetails.getAuthorities()));

		final String jwtToken = jwtTokenUtil.createToken(authentication);

		return ResponseEntity.ok(new AuthenticationResponse(jwtToken));
	}
}
