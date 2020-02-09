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
public class UserEntity {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	private String id;

	@Column(nullable = false, unique = true)
	private String userName;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private UserRole role;

	@Column(nullable = false)
	private String password;
	
	public UserEntity() {
		super();
	}

	public UserEntity(UserRole role, String userName, String password) {
		super();
		this.role = role;
		this.userName = userName;
		this.password = password;
	}

	public UserEntity(String id, UserRole role, String userName, String password) {
		super();
		this.id = id;
		this.role = role;
		this.userName = userName;
		this.password = password;
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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String email) {
		this.userName = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
