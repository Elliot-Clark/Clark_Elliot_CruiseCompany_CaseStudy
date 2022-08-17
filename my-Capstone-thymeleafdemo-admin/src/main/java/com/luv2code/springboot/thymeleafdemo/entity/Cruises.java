package com.luv2code.springboot.thymeleafdemo.entity;

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
@Table(name = "cruises")
public class Cruises {

	@Id
	@Column(name = "id")
	private int id;

	@Column(name = "destination")
	private String destination;

	@Column(name = "leaving_from")
	private String leavingFrom;

	@Column(name = "departure_date")
	private String departureDate;

	@Column(name = "duration")
	private int duration;

	@Column(name = "price")
	private int price;

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "customers_cruises", joinColumns = @JoinColumn(name = "cruises_id"), inverseJoinColumns = @JoinColumn(name = "customers_email"))
	private List<Customer> sCustomer;

	public List<Customer> getsCustomer() {
		return sCustomer;
	}

	public Cruises() {

	}

	public void setsCustomer(List<Customer> sCustomer) {
		this.sCustomer = sCustomer;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getLeavingFrom() {
		return leavingFrom;
	}

	public void setLeavingFrom(String leavingFrom) {
		this.leavingFrom = leavingFrom;
	}

	public String getDepatureDate() {
		return departureDate;
	}

	public void setDepatureDate(String depatureDate) {
		this.departureDate = depatureDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
