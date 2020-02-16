package com.shapeshop.util;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Service
public class JwtUtil {

	private static String SECRET_KEY = "secret";
	public static final long ACCESS_TOKEN_VALIDITY_SECONDS = 5 * 60 * 60;
	public static final String AUTHORITIES_KEY = "scopes";

	
	public Boolean validateToken(String token, UserDetails userDetails) {
		
		String username = extractClaim(token, Claims::getSubject);
		Date exp = extractClaim(token, Claims::getExpiration);
		
		return (username.equals(userDetails.getUsername()) && !exp.before(new Date()));
	}

	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}


	public static <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		
		final Claims claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
		
		return claimsResolver.apply(claims);
	}



	public UsernamePasswordAuthenticationToken getAuthentication(final String token, final Authentication existingAuth,
			final UserDetails userDetails) {

		final JwtParser jwtParser = Jwts.parser().setSigningKey(SECRET_KEY);

		final Jws<Claims> claimsJws = jwtParser.parseClaimsJws(token);

		final Claims claims = claimsJws.getBody();

		final Collection<? extends GrantedAuthority> authorities = Arrays
				.stream(claims.get(AUTHORITIES_KEY).toString().split(",")).map(SimpleGrantedAuthority::new)
				.collect(Collectors.toList());

		for (GrantedAuthority grantedAuthority : authorities) {
			System.out.println("Got an Authority (claims) from token in header : " + grantedAuthority.getAuthority());
		}

		return new UsernamePasswordAuthenticationToken(userDetails, "", authorities);
	}

	/**
	 * Creates Token
	 */
	public String createToken(Authentication authentication) {
		final String authorities = authentication.getAuthorities().stream().map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining(","));

		return Jwts.builder().setSubject(authentication.getName()).claim(AUTHORITIES_KEY, authorities)
				.signWith(SignatureAlgorithm.HS256, SECRET_KEY).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS * 1000)).compact();
	}


}