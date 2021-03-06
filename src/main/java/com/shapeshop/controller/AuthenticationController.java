package com.shapeshop.controller;

import com.shapeshop.model.AuthenticationRequest;
import com.shapeshop.model.AuthenticationResponse;
import com.shapeshop.service.UserService;
import com.shapeshop.security.JwtUtil;
import com.shapeshop.security.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

/**
 * Login/Logout endpoints.
 */

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

	/**
	 * Authenticate a user who is trying to log in.
	 *
	 * @param authenticationRequest authentication request when logging in
	 * @return HTTP response enttiy
	 * @throws Exception
	 */
	@CrossOrigin
	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> loginAndCreateAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {


			Authentication authentication = null;

			String pswd = authenticationRequest.getPassword();
			String uName = authenticationRequest.getUsername();

			System.out.println("logging in a user " + uName + " pswd " + pswd);

			String encryptedPswd = passwordValidationService.encryptPassword(pswd);

			System.out.println("encryptedPswd " + encryptedPswd);

			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

			System.out.println("loaded use details " + userDetails);

			authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(uName, encryptedPswd, userDetails.getAuthorities()));

			final String jwtToken = jwtTokenUtil.createToken(authentication);

			System.out.println("got a new token " + jwtToken);

			return ResponseEntity.ok(new AuthenticationResponse(jwtToken));

		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@CrossOrigin
	@RequestMapping(value = "/logout", method = RequestMethod.POST)
	public ResponseEntity<?> logout(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

//		Authentication authentication = null;
//
//		String pswd = authenticationRequest.getPassword();
//		String uName = authenticationRequest.getUsername();
//		String encryptedPswd = passwordValidationService.encryptPassword(pswd);
//
//		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//
//		authentication = authenticationManager
//				.authenticate(new UsernamePasswordAuthenticationToken(uName, encryptedPswd, userDetails.getAuthorities()));
//
//		final String jwtToken = jwtTokenUtil.createToken(authentication);
//
		return ResponseEntity.ok(new AuthenticationResponse("TODO this isnt working correctly"));
	}
}
