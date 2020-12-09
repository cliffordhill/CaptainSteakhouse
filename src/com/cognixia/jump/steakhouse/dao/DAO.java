package com.cognixia.jump.steakhouse.dao;

import java.util.List;

public interface DAO<T> {
	// methods for interacting with DB
	// list All entries of a Table
	// public List <Table> getAllTable();
	public List<T> getAll();

	// list one entry of a table by ID
	// public Table getById(int tableId);
	public T getById(int id);

	// list one entry of a table by NAME
	// public Table getByName(String name, String name_value);
	public T getByAttribute(String attribute, String value);

	// add a row to a table
	// public boolean addTable(Table table);
	public boolean add(T entry);

	// delete a row to a table
	// public boolean deleteTable(int tableId);
	public boolean deleteById(int id);

	// update a table
	// public int updateTable(Table table);
	public boolean update(T entry);

	
	
}
