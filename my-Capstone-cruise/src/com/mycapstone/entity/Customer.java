package com.mycapstone.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "password")
	private String password;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "customers_cruises", joinColumns = @JoinColumn(name = "customers_email"), inverseJoinColumns = @JoinColumn(name = "cruises_id"))
	private List<Cruises> sCruises;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Customer() {

	}

	public List<Cruises> getsCruises() {
		return sCruises;
	}

	public void setsCruises(List<Cruises> sCruises) {
		this.sCruises = sCruises;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", sCruises=" + sCruises + "]";
	}

}
