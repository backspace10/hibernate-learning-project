package com.tut;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="student_adress")
public class Address {

	@Id //this annotation pk
	@GeneratedValue(strategy= GenerationType.IDENTITY) //this annotation for auto generating value
	@Column(name="address_id") //we r explicitelly providing colum name id => address_id
	private int id;
	
	@Column(length=50, name="STREET")
	private String street;
	
//	@Column(length=50, name="City")
	private String city;
	private boolean isOpen;
	
	@Transient //this is for hibernate don't create column in table
	private double x;
	
	@Temporal(TemporalType.DATE) //it will only store date not timestamp
	private Date addressDate;
	
	@Lob
	private byte[] image;

	public Address() {
		super();
	}

	public Address(int id, String street, String city, boolean isOpen, double x, Date addressDate, byte[] image) {
		super();
		this.id = id;
		this.street = street;
		this.city = city;
		this.isOpen = isOpen;
		this.x = x;
		this.addressDate = addressDate;
		this.image = image;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public Date getAddressDate() {
		return addressDate;
	}

	public void setAddressDate(Date addressDate) {
		this.addressDate = addressDate;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

}
