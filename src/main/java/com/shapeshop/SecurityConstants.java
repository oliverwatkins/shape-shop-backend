package com.shapeshop;

public final class SecurityConstants {
    public static final String SECRET = "75ykAIZDelKmgaibWi7oO3e4Fd9jEtBmLjvQYCe5ieT9O4JDgmEkmxPWZ1c3TWn2";
    // 10 days
    public static final long EXPIRATION_TIME = 864_000_000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String JWT_HEADER_KEY_NAME = "Authorization";
    public static final String USER_ROLE = "role";
    public static final String USER_STATUS = "status";
    public static final String ACTIVE_USER = "active";
    public static final String NOT_VERIFIED_USER = "not verified";
    public static final String VERIFIED_AUTHORITY = "VERIFIED";


    private SecurityConstants() {
    }
}
