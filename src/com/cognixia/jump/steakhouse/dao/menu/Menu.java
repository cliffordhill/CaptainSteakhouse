package com.cognixia.jump.steakhouse.dao.menu;

public class Menu {

	private int menu_id;
	private String category_name;
	private String item_name;
	private float price;
	
	
	public Menu(int menu_id, String category_name, String item_name, float price) {
		super();
		this.menu_id = menu_id;
		this.category_name = category_name;
		this.item_name = item_name;
		this.price = price;
	}


	public Menu(String category_name, String item_name, float price) {
		super();
		this.category_name = category_name;
		this.item_name = item_name;
		this.price = price;
	}


	public Menu(String category_name, String item_name, float price, int menu_id) {
		super();
		this.category_name = category_name;
		this.item_name = item_name;
		this.price = price;
		this.menu_id = menu_id;
	}


	public int getMenu_id() {
		return menu_id;
	}


	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}


	public String getCategory_name() {
		return category_name;
	}


	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}


	public String getItem_name() {
		return item_name;
	}


	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Menu [menu_id=" + menu_id + ", category_name=" + category_name + ", item_name=" + item_name + ", price="
				+ price + "]";
	}
	
	
	
}
