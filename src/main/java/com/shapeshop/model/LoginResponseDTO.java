package com.shapeshop.model;

public class LoginResponseDTO {

	private String role;
    private String membershipId;

	public LoginResponseDTO(String string, String membershipId2) {
		
		this.role = string;
		this.membershipId = membershipId2;
		
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setMembershipId(String membershipId) {
		this.membershipId = membershipId;
	}
    
    public String getRole() {
		return role;
	}
	public String getMembershipId() {
		return membershipId;
	}

}
