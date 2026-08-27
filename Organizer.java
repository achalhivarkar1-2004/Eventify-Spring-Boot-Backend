package com.eventify.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Organizer")
public class Organizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long organizerId;

    private String name;

    private String email;

    private String phone;

    private String organizationName;

    private String passwordHash;

    @Enumerated(EnumType.STRING)
    private AccountStatus accountStatus;

	public Long getOrganizerId() {
		return organizerId;
	}

	public void setOrganizerId(Long organizerId) {
		this.organizerId = organizerId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public AccountStatus getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "Organizer [organizerId=" + organizerId + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", organizationName=" + organizationName + ", passwordHash=" + passwordHash + ", accountStatus="
				+ accountStatus + "]";
	}

   
    
}