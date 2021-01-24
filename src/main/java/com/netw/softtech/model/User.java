package com.netw.softtech.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class User {
	
	@Id
	@NotEmpty
	@Column(unique = true)
	private String email;
	@NotEmpty
	private String name;
	@Size(min=4)
	private String password;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="USER_ROLES",joinColumns =
            {@JoinColumn(name="USER_Email",referencedColumnName = "email")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_NAME", referencedColumnName = "name") })
	private List<Role> roles;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Role> getRoles() {
		return roles;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}
	public User() {
		
	}
	

}
