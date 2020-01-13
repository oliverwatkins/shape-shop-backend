package com.shapeshop.entity;

import java.time.LocalDateTime;
import java.util.Locale;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.shapeshop.model.UserRole;
import com.shapeshop.model.UserStatus;

@Entity
@Table(name = "users")
public class User {


	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private UserRole role;

	@Column(nullable = false, unique = true)
	private String email;

	@Column(nullable = false)
	private String password;

	private String customerId;
	
	public User() {
		super();
	}

	public User(UserRole role, String email, String password, String customerId, String membershipId, Locale locale) {
		super();
		this.role = role;
		this.email = email;
		this.password = password;
		this.customerId = customerId;
		this.locale = locale;
	}

	public User(String id, UserRole role, String email, String password, String customerId, String membershipId,
			LocalDateTime passwordChangeDate, Locale locale, UserStatus status) {
		super();
		this.id = id;
		this.role = role;
		this.email = email;
		this.password = password;
		this.customerId = customerId;
		this.passwordChangeDate = passwordChangeDate;
		this.locale = locale;
		this.status = status;
	}


	@Column(name = "password_change_dt")
	private LocalDateTime passwordChangeDate;

	private Locale locale;

	@Enumerated(EnumType.STRING)
	private UserStatus status = UserStatus.NOT_VERIFIED;

	public boolean isActive() {
		return UserStatus.ACTIVE.equals(status);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public LocalDateTime getPasswordChangeDate() {
		return passwordChangeDate;
	}

	public void setPasswordChangeDate(LocalDateTime passwordChangeDate) {
		this.passwordChangeDate = passwordChangeDate;
	}

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

}
