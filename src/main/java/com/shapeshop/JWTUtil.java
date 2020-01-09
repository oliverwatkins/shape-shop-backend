package com.shapeshop;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.UUID;

public final class JWTUtil {

    private static final Algorithm ALGORITHM = Algorithm.HMAC512(SecurityConstants.SECRET.getBytes(ProjectConstants.DEFAULT_CHARSET));

    private JWTUtil() {
    }

    public static String createToken(String role, String status, Date expiresAt) {
        // this salt is needed in case we receive two login requests at the same time
        // calling it track in case someone decode our token, it would not expose its idea
        var track = UUID.randomUUID().toString();

        var token = JWT.create()
            .withExpiresAt(expiresAt)
            .withClaim(SecurityConstants.USER_ROLE, role)
            .withClaim(SecurityConstants.USER_STATUS, status)
            .withClaim("Track", track)
            .sign(ALGORITHM);

        return SecurityConstants.TOKEN_PREFIX + token;
    }

    public static DecodedJWT decode(String encodedJwtToken) {
        var formattedToken = encodedJwtToken.replace(SecurityConstants.TOKEN_PREFIX, "");

        // decode the token.
        return JWT.require(ALGORITHM)
            .build()
            .verify(formattedToken);
    }
}
