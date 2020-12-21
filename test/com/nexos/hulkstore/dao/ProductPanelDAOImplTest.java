package com.nexos.hulkstore.dao;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import com.nexos.hulkstore.model.Product;

/**
 * @author Carlos
 */
public class ProductPanelDAOImplTest {
	private static Logger logger = Logger.getLogger(ProductPanelDAOImplTest.class);
	/**
	 * Donde están la mayoría de los métodos básicos
	 */
	private ProductPanelDAOImpl productPanelDAOImpl;
	/**
	 * Estructura para los datos
	 */
	private Product product;
	
	@Before
	public void before() {
		
		productPanelDAOImpl = new ProductPanelDAOImpl();
		product =new Product();
	}
	
	@Test
	public void testInsertEntrada() {
		
		product.setProductName("testjunitsalida");
		product.setInputQuantity(10);
		product.setInputPrice(7800);
		product.setQuantityTotal(7800);
		productPanelDAOImpl.insertEntrada(product);
		Product products = productPanelDAOImpl.consult(product);
		
		assertEquals("Correcta", (products.getProductName()), "testjunitsalida");
	}
	
	@Test
	public void testConsult() {
		// se crea un producto de prueba testjunit
		product.setProductName("testjunitsalida");
		Product products = productPanelDAOImpl.consult(product);
		assertEquals("Correcta", (products.getProductName()), "testjunitsalida");
	}
	
	@Test
	public void testConsult2() {
		// se crea un producto de prueba testjunit
		product.setProductName("juguete01");
		Product products = productPanelDAOImpl.consult(product);
		
		assertEquals("Correcta", (products.getProductName()), "juguete01");
	}
	
}
