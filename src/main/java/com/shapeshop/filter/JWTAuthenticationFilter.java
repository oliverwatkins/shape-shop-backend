//package com.shapeshop.filter;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.shapeshop.model.ApplicationUser;
//import com.shapeshop.service.UserTokenService;
//import com.shapeshop.util.SecurityConstants;
//
//
//public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
//
//    private final UserTokenService userTokenService;
//    private final AuthenticationManager authenticationManager;
//
//    public JWTAuthenticationFilter(AuthenticationManager authenticationManager,
//                                   UserTokenService userTokenService) {
//        this.authenticationManager = authenticationManager;
//        this.userTokenService = userTokenService;
//    }
//
//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest req,
//                                                HttpServletResponse res) throws AuthenticationException {
//        try {
//            var credential = new ObjectMapper().readValue(req.getInputStream(), ApplicationUser.class);
//
//            var authToken = new UsernamePasswordAuthenticationToken(
//                credential.getEmail(),
//                credential.getPassword(),
//                List.of()
//            );
//
//            Authentication auth =  authenticationManager.authenticate(authToken);
//            return auth;
//        } catch (IOException ex) {
//            throw new IllegalArgumentException(ex);
//        }
//    }
//
//    @Override
//    protected void unsuccessfulAuthentication(HttpServletRequest request,
//                                              HttpServletResponse response,
//                                              AuthenticationException ex) throws IOException, ServletException {
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//    }
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request,
//                                            HttpServletResponse response,
//                                            FilterChain chain,
//                                            Authentication auth) throws IOException, ServletException {
//
//        var userEmail = auth.getPrincipal().toString();
//
//        var userToken = userTokenService.createToken(userEmail);
//
//        response.addHeader(SecurityConstants.JWT_HEADER_KEY_NAME, userToken.getToken());
//    }
//}
