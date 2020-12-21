package com.nexos.hulkstore.dao;

public interface DAO  <T>{
	
	T consult (T data);
	void insertSalida (T data);
	void insertEntrada (T data);
	void newInsert (T data);
}
