/**
 * 
 */
package com.nexos.hulkstore.controller;

import com.nexos.hulkstore.dao.ProductPanelDAOImpl;
import com.nexos.hulkstore.model.Product;

/**
 * @author Carlos
 *
 */
public class ControllerKardex {
	
	ProductPanelDAOImpl productPanelDAOImpl;
	
	public ControllerKardex() {
		productPanelDAOImpl = new ProductPanelDAOImpl();
	}

	/**
	 * Consulta producto
	 * @param searchProduct
	 * @return 
	 */
	public Product consult(Product searchProduct) {
		return productPanelDAOImpl.consult(searchProduct);
	}
	
	/**
	 * Inserta un producto entrante
	 * @param insertProduct
	 */
	public void insertEntrada(Product insertProduct) {
		productPanelDAOImpl.insertEntrada(insertProduct);
	}	

	/**
	 * Inserta un producto saliente
	 * @param insertProduct
	 */
	public void insertSalida(Product insertProduct) {
		productPanelDAOImpl.insertSalida(insertProduct);
	}

	/**
	 * Inseta un producto nuevo (que no existe)
	 * @param newInsert
	 */
	public void newInsert(Product newInsert) {
		productPanelDAOImpl.newInsert(newInsert);
	}
	
}
