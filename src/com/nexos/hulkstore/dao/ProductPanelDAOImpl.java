/**
 * 
 */
package com.nexos.hulkstore.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.nexos.hulkstore.model.Product;
import com.nexos.hulkstore.util.ExcelUtil;
import com.nexos.hulkstore.util.GetProperties;
import com.nexos.hulkstore.exception.HulkStoreException;

/**
 * @author Carlos
 *
 */
public class ProductPanelDAOImpl implements ProductPanelDAO{

	private static String path = null;
	private static Logger logger = Logger.getLogger(ProductPanelDAOImplTest.class);
	
	public ProductPanelDAOImpl() {
		path = GetProperties.getInstance().getdataProperties("file_excel");
	}
	
	@Override
	public Product consult(Product product) {
		List<ArrayList<String>> data;
		try {
			data = ExcelUtil.readAll(path, "Hoja1");

			// De abajo hacia arriba, retorna el primer row con ese producto (el último)
			for (int i = data.size()-1; i > 1; i--) {
				if (data.get(i).get(0).equalsIgnoreCase(product.getProductName())) {
					product.setId(i);
					product.setQuantityTotal(Integer.parseInt((data.get(i).get(5))));
					product.setPrice(Double.parseDouble(data.get(i).get(6)));
					
					return product;
				}
			}
		} catch (HulkStoreException e) {
			logger.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Insert entrada (compra) producto existente
	 */
	@Override
	public void insertEntrada(Product data) {
		
		Double newOutPrice = (data.getInputPrice()*0.3) + data.getInputPrice();
		List<Object> datas = new ArrayList<Object>();
		
		datas.add(data.getProductName());
		datas.add("");
		datas.add("");
		datas.add(Integer.valueOf(data.getInputQuantity()));
		datas.add(String.valueOf(data.getInputPrice()));
		datas.add(data.getInputQuantity() + data.getQuantityTotal());
		datas.add(String.valueOf(newOutPrice));
		
		ExcelUtil.insertRowData(path, "Hoja1", datas);
	}

	/**
	 * Insert salida (venta)
	 */
	@Override
	public void insertSalida(Product data) {
		
		List<Object> datas = new ArrayList<Object>();
		
		//productos salida
		datas.add(data.getProductName());
		datas.add(Integer.valueOf(data.getOutputQuantity()));
		datas.add(String.valueOf(data.getOutputPrice()));
		datas.add("");
		datas.add("");
		datas.add(Integer.valueOf(data.getQuantityTotal()));
		datas.add(String.valueOf(data.getOutputPrice()));
		
		ExcelUtil.insertRowData(path, "Hoja1", datas);
	}
	
	/**
	 * Insert entrada (compra) producto no existente
	 */
	@Override
	public void newInsert(Product data) {
		
		Double newOutPrice = (data.getInputPrice()*0.3) + data.getInputPrice();
		List<Object> datas = new ArrayList<Object>();
		
		datas.add(data.getProductName());
		datas.add("");
		datas.add("");
		datas.add(Integer.valueOf(data.getInputQuantity()));
		datas.add(String.valueOf(data.getInputPrice()));
		datas.add(Integer.valueOf(data.getInputQuantity()));
		datas.add(String.valueOf(newOutPrice));
		
		ExcelUtil.insertRowData(path, "Hoja1", datas);
	}

}
