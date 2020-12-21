/**
 * 
 */
package com.nexos.hulkstore.model;

/**
 * @author Carlos
 *
 */
public class Product {
	/**
	 * ID producto
	 */
	private long id;
	
	/**
	 * Nombre del producto
	 */
	private String productName;
	
	/**
	 * Valor entrada compra
	 */
	private double inputPrice;
	
	/**
	 * Valor salida venta
	 */
	private double outputPrice;
	
	/**
	 * Cantidad entrada
	 * @return
	 */
	private int outputQuantity;
	
	/**
	 * cantidad saldia
	 */
	private int inputQuantity;
	
	/**
	 * cantidad total después de transacción
	 */
	private int quantifyTotal;
	
	/**
	 * precio de venta nuevo
	 */
	private double price;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public double getInputPrice() {
		return inputPrice;
	}
	
	public void setInputPrice(double inputPrice) {
		this.inputPrice = inputPrice;
	}
	
	public int getOutputQuantity() {
		return outputQuantity;
	}
	
	public void setOutputQuantity(int outputQuantity) {
		this.outputQuantity = outputQuantity;
	}
	
	public int getInputQuantity() {
		return inputQuantity;
	}

	public void setInputQuantity(int inputQuantity) {
		this.inputQuantity = inputQuantity;
	}

	public double getOutputPrice() {
		return outputPrice;
	}
	
	public void setOutputPrice(double outputPrice) {
		this.outputPrice = outputPrice;
	}

	public int getQuantityTotal() {
		return quantifyTotal;
	}

	public void setQuantityTotal(int quantifyTotal) {
		this.quantifyTotal = quantifyTotal;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
