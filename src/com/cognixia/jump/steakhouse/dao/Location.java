package com.cognixia.jump.steakhouse.dao;

public class Location {

	private int location_id;
	private String name;
	private String address;
	private String city;
	private String state;
	private int zip;
	private String phone;

	public Location(int location_id, String name, String address, String city, String state, int zip,
			String phone) {
		super();
		this.location_id = location_id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}

	public Location(int location_id, String address, String city, String state, int zip, String phone) {
		super();
		this.location_id = location_id;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phone = phone;
	}
	
	public Location(String name, String address, int zip) {
		super();
		this.name = name;
		this.address = address;
		this.zip = zip;
	}
	
	public Location(String city, String state, String phone, int location_id) {
		super();
		this.city = city;
		this.state = state;
		this.phone = phone;
		this.location_id = location_id;
	}
	
	public Location(int location_id) {
		super();
		this.location_id = location_id;
	}

	public int getId() {
		return location_id;
	}

	public void setId(int location_id) {
		this.location_id = location_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "\nLocation ID " + location_id + " located at:\n" + address + "\n" + city + ", " + state + " " + zip
				+ "\nPhone Number: " + phone;
	}

	
}
