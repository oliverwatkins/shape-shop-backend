package com.shapeshop.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import com.shapeshop.model.UserStatus;

import lombok.Getter;

@Entity
@Table(name = "user_tokens")
public class UserToken {

    @Id
    @Column(nullable = false, unique = true)
    @Getter
    private String token;

    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExpiresAt() {
		return expiresAt;
	}

	public void setExpiresAt(Date expiresAt) {
		this.expiresAt = expiresAt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    private Date expiresAt;

    @OneToOne
    private User user;

    public UserToken(User user2, Date expiresAt2, String jwtToken) {
    	
    	this.user = user2;
    	this.expiresAt = expiresAt2;
    	this.token = jwtToken;
	}

	@Transient
    public String getRole() {
        return user.getRole().name();
    }

    @Transient
    public String getUserEmail() {
        return user.getEmail();
    }

    @Transient
    public String getCustomerId() {
        return user.getCustomerId();
    }

    @Transient
    public UserStatus getStatus() {
        return user.getStatus();
    }

    @Transient
    public boolean isActive() {
        return user.isActive();
    }
}
