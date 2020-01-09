package com.shapeshop.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import com.shapeshop.SecurityConstants;


@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class LoggedUserInfo {
	
	private String role;
    private String customerId;
    private String membershipId;
    private boolean active;

    public List<GrantedAuthority> getGrantedAuthorities() {
        var grantedAuthorities = new ArrayList<GrantedAuthority>();
        if (active) {
            grantedAuthorities.add(new SimpleGrantedAuthority(SecurityConstants.VERIFIED_AUTHORITY));
        }
        return grantedAuthorities;
    }
    
    public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}


}
