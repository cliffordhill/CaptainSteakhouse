package com.cognixia.jump.steakhouse.dao.chef;

public class Chef {
	
	private int chef_id;
	private String first_name;
	private String last_name;
	private int location_id;
	
	public Chef(int chef_id, String first_name, String last_name, int location_id) {
		super();
		this.chef_id = chef_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.location_id = location_id;
	}

	public Chef(String first_name, String last_name, int location_id) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.location_id = location_id;
	}

	public Chef(String first_name, String last_name, int location_id, int chef_id) {
		super();
		this.chef_id = chef_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.location_id = location_id;
	}

	public Chef(String first_name, String last_name) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public Chef(int chef_id, String first_name, String last_name) {
		super();
		this.chef_id = chef_id;
		this.first_name = first_name;
		this.last_name = last_name;
	}

	public int getChef_id() {
		return chef_id;
	}

	public void setChef_id(int chef_id) {
		this.chef_id = chef_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getLocation_id() {
		return location_id;
	}

	public void setLocation_id(int location_id) {
		this.location_id = location_id;
	}

	@Override
	public String toString() {
		return "Chef [chef_id=" + chef_id + ", first_name=" + first_name + ", last_name=" + last_name + ", location_id="
				+ location_id + "]";
	}
	
	

}
