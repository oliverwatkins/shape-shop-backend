//package com.shapeshop.filter;
//
//import java.io.IOException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
//
//import com.shapeshop.entity.UserToken;
//import com.shapeshop.model.LoggedUserInfo;
//import com.shapeshop.service.UserTokenService;
//import com.shapeshop.util.JWTUtil;
//import com.shapeshop.util.SecurityConstants;
//
//
//
//
//
///**
// * BasicAuthenticationFilter extends OncePerRequestFilter  
// * 
// */
//public class JWTAuthorizationFilter extends BasicAuthenticationFilter {
//
//    private final LoggedUserInfo loggedUserInfo;
//    private final UserTokenService userTokenService;
//
//    public JWTAuthorizationFilter(AuthenticationManager authManager,
//                                  LoggedUserInfo loggedUserInfo,
//                                  UserTokenService userTokenService) {
//        super(authManager);
//        this.loggedUserInfo = loggedUserInfo;
//        this.userTokenService = userTokenService;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain chain) throws IOException, ServletException {
//        var headerToken = request.getHeader(SecurityConstants.JWT_HEADER_KEY_NAME);
//
//        if (headerToken == null || !headerToken.startsWith(SecurityConstants.TOKEN_PREFIX)) {
//            chain.doFilter(request, response);
//            return;
//        }
//
//        var userToken = userTokenService.findByToken(headerToken);
//
//        if (userToken == null) {
//            handleInvalidToken(request, response, chain, headerToken);
//            return;
//        }
//
//        var authentication = getAuthentication(userToken);
//
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        chain.doFilter(request, response);
//    }
//
//    private void handleInvalidToken(HttpServletRequest request,
//                                    HttpServletResponse response,
//                                    FilterChain chain,
//                                    String headerToken) throws IOException, ServletException {
//        var jwtToken = JWTUtil.decode(headerToken);
//        
//        System.out.println("invalid token detected for user: " + jwtToken.getSubject() + " with token: " + headerToken);
//        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
//        chain.doFilter(request, response);
//    }
//
//    private UsernamePasswordAuthenticationToken getAuthentication(UserToken userToken) {
//        var userRole = userToken.getRole();
//        var customerId = userToken.getCustomerId();
//
//        loggedUserInfo.setRole(userRole);
//        loggedUserInfo.setCustomerId(customerId);
//        loggedUserInfo.setActive(userToken.isActive());
//
//        return new UsernamePasswordAuthenticationToken(
//            userToken.getUserEmail(),
//            null,
//            loggedUserInfo.getGrantedAuthorities());
//    }
//}
