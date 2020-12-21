package com.nexos.hulkstore.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.SwingConstants;

/**
 * Panel que indica stock de productos
 * 
 * @author Carlos
 */
public class StockPanel extends JPanel {
	private JTextField tfStock;

	public StockPanel() {
		setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		setLayout(new GridLayout(1, 2, 5, 5));
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.RIGHT);
		add(lblStock);
		
		tfStock = new JTextField();
		tfStock.setHorizontalAlignment(SwingConstants.CENTER);
		tfStock.setEditable(false);
		add(tfStock);
		tfStock.setColumns(10);

	}
	
	/**
	 * @return the tfStock
	 */
	public JTextField getTfStock() {
		return tfStock;
	}

	/**
	 * @param tfStock the tfStock to set
	 */
	public void setTfStock(String tfStock) {
		this.tfStock.setText(tfStock);
	}

	public void clear() {
		tfStock.setText("");
	}

}
