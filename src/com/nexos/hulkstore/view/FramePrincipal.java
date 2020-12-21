package com.nexos.hulkstore.view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import org.apache.log4j.Logger;

import com.nexos.hulkstore.controller.ControllerKardex;
import com.nexos.hulkstore.exception.HulkStoreException;
import com.nexos.hulkstore.model.Product;
import javax.swing.UIManager;

/**
 * Ventana principal
 * 
 * @author Carlos
 */
public class FramePrincipal extends JFrame {

	private JPanel contentPane;
	
	private SearchProductPanel searchProductPanel;
	private OutputProductPanel outputProductPanel ;
	private InputProductPanel inputProductPanel;
	private StockPanel stockPanel;
	private ControllerKardex controllerKardex;
	private Product productSearch;
	private Product insertProduct;
	
	private static Logger logger = Logger.getLogger(FramePrincipal.class);

	public FramePrincipal() {
		
		insertProduct = new Product();
		controllerKardex = new ControllerKardex();
		
		setTitle("KARDEX HULK STORE");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 294);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		searchProductPanel = new SearchProductPanel(this);
		contentPane.add(searchProductPanel, BorderLayout.NORTH);
		
		outputProductPanel = new OutputProductPanel(this);
		contentPane.add(outputProductPanel, BorderLayout.WEST);
		
		inputProductPanel = new InputProductPanel(this);
		contentPane.add(inputProductPanel, BorderLayout.CENTER);
		
		stockPanel = new StockPanel();
		stockPanel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(stockPanel, BorderLayout.SOUTH);
	}

	/**
	 * Busca producto existente
	 * 
	 * @throws HulkStoreException
	 */
	public void searchProduct() throws HulkStoreException{
		outputProductPanel.clear();
		inputProductPanel.clear();
		stockPanel.clear();
		
		if (productSearch == null) {
			productSearch = new Product();
		}
		productSearch.setProductName(searchProductPanel.getTfproducto());

		logger.info("Buscar producto " + searchProductPanel.getTfproducto());
		validateField("Nombre del producto", searchProductPanel.getTfproducto());

		productSearch = controllerKardex.consult(productSearch);
		
		if (productSearch == null) {
			logger.info("No se encontro el producto");
			JOptionPane.showMessageDialog(this, "No se encontro el producto");
		} else {
			logger.info("Producto " + productSearch.getProductName() + " encontrado");
			
			//setea resultados en los paneles:
			outputProductPanel.setTfProduct(productSearch.getProductName());
			stockPanel.setTfStock(String.valueOf(productSearch.getQuantityTotal()));
			outputProductPanel.setTfOutputPrice(String.valueOf(productSearch.getPrice()));
		}
	}
		
	/**
	 * Guarda producto es venta salida
	 * @throws HulkStoreException
	 */
	public void saveOutputProduct() throws HulkStoreException {
		Product product = new Product();
		validateField("Producto", outputProductPanel.getTfProduct());
		validateField("Cantidad", outputProductPanel.getTfOutputQuantity());
		validateInt("Cantidad", outputProductPanel.getTfOutputQuantity());
		
		product.setId(productSearch.getId());
		product.setOutputQuantity(Integer.parseInt(outputProductPanel.getTfOutputQuantity()));
		product.setProductName(outputProductPanel.getTfProduct());
		product.setOutputPrice(Double.parseDouble(outputProductPanel.getTfOutputPrice())); 

		if (productSearch.getQuantityTotal() < Integer.parseInt(outputProductPanel.getTfOutputQuantity())) {
			JOptionPane.showMessageDialog(this,
					" La cantidad de producto que desea retirar es mayor a la del inventario");
		} else {
			
			product.setQuantityTotal(productSearch.getQuantityTotal() - Integer.parseInt(outputProductPanel.getTfOutputQuantity()));
			
			controllerKardex.insertSalida(product);
			
			outputProductPanel.clear();
			stockPanel.clear();
			searchProductPanel.clear();
			inputProductPanel.clear();
		}
	}
	
	/**
	 * Inserta nueva entrada de producto
	 * 
	 * @throws HulkStoreException
	 */
	public void saveInputProduct() throws HulkStoreException {
		
		String nameProduct = inputProductPanel.getTfProduct();

		validateField("Producto", nameProduct);
		validateField("Valor entrada", inputProductPanel.getTfInputPrice());
		validateField("Cantidad", inputProductPanel.getTfInputQuantity());
		validateInt("Cantidad", inputProductPanel.getTfInputQuantity());
		validateDouble("Valor entrada", inputProductPanel.getTfInputPrice());
		
		double price = Double.parseDouble(inputProductPanel.getTfInputPrice());
		int quantity = Integer.parseInt(inputProductPanel.getTfInputQuantity());

		insertProduct.setProductName(nameProduct);
		insertProduct.setProductName(nameProduct);
		insertProduct.setInputQuantity(quantity);
		insertProduct.setInputPrice(price);
		logger.info("Producto a ingresar:  nombre " + nameProduct + ", Cantidad " + quantity + ", precio " + price);
		
		// se puede cambiar valor de producto si es nuevo en inventario
		if (controllerKardex.consult(insertProduct) != null) {
			
			controllerKardex.insertEntrada(insertProduct);
			
		}else {
			controllerKardex.newInsert(insertProduct);
		}

		outputProductPanel.clear();
		stockPanel.clear();
		searchProductPanel.clear();
		inputProductPanel.clear();
	}
	
	/**
	 * Valida campos vacios
	 * 
	 * @param nameField
	 * @param text
	 * @throws HulkStoreException
	 */
	public void validateField(String nameField, String text) throws HulkStoreException {
		if (text.length() < 1) {
			JOptionPane.showMessageDialog(this, "Campo " + nameField + " está vacío");
			throw new HulkStoreException("Campo " + nameField + " está vacío");
		}
	}

	/**
	 * Valida si el valor es un número
	 * 
	 * @param nameField
	 * @param text
	 * @throws HulkStoreException
	 */
	public void validateInt(String nameField, String text) throws HulkStoreException {
		try {
			Integer.parseInt(text);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Campo " + nameField + " no es un número");
			throw new HulkStoreException("Campo " + nameField + "  no es un número");
		}
	}
	
	/**
	 * Valida si el valor es un número
	 * 
	 * @param nameField
	 * @param text
	 * @throws HulkStoreException
	 */
	public void validateDouble(String nameField, String text) throws HulkStoreException {
		try {
			Double.parseDouble(text);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "Campo " + nameField + " no es un número");
			throw new HulkStoreException("Campo " + nameField + " no es un número");
		}
	}
	
}
