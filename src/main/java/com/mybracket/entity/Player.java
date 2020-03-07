package com.mybracket.entity;

import javax.persistence.*;


@Entity
@Table(name="player")
public class Player {

	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;
	
	@Column(name="role")
	private String role;
	
	private String confirmPass;
	public boolean matchResult; 
	public boolean inMatch = false;
	
	// constructors
	public Player() {}
	
	public Player(String firstName){
		this.firstName = firstName;
	}
	
	public Player(String username, String email, String password, String firstName, String lastName,
			String confirmPass) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.confirmPass = confirmPass;
	}
	
	
	
	
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isMatchResult() {
		return matchResult;
	}

	public void setMatchResult(boolean matchResult) {
		this.matchResult = matchResult;
	}

	public boolean isInMatch() {
		return inMatch;
	}

	public void setInMatch(boolean inMatch) {
		this.inMatch = inMatch;
	}

	public String getConfirmPass() {
		return confirmPass;
	}

	public void setConfirmPass(String confirmPass) {
		this.confirmPass = confirmPass;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	@Override
	public String toString() {
		return "Player [username=" + username + ", email=" + email + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", confirmPass=" + confirmPass + "]";
	}
	
	
	
	
}
