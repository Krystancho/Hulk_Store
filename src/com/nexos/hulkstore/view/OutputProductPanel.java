package com.nexos.hulkstore.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;
import com.nexos.hulkstore.exception.HulkStoreException;
import javax.swing.UIManager;

/**
 * Panel de gestión de productos
 * (venta y compra de productos existentes).
 * 
 * @author Carlos
 *
 */
public class OutputProductPanel extends JPanel {
	private JTextField tfProducto;
	private JTextField tfValorSalida;
	private JTextField tfCantidadSalida;
	private FramePrincipal framePrincipal;
	private static Logger logger = Logger.getLogger(OutputProductPanel.class);

	public OutputProductPanel(FramePrincipal framePrincipal) {
		this();
		this.framePrincipal=framePrincipal;
	}
	
	public OutputProductPanel() {
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Salidas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		setLayout(new GridLayout(4, 2, 5, 5));
		
		JLabel lblProducto = new JLabel("Producto");
		add(lblProducto);
		
		tfProducto = new JTextField();
		tfProducto.setEditable(false);
		add(tfProducto);
		tfProducto.setColumns(10);
		
		JLabel lblValor = new JLabel("Valor salida");
		add(lblValor);
		
		tfValorSalida = new JTextField();
		tfValorSalida.setEditable(false);
		add(tfValorSalida);
		tfValorSalida.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		add(lblCantidad);
		
		tfCantidadSalida = new JTextField();
		add(tfCantidadSalida);
		tfCantidadSalida.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					
					framePrincipal.saveOutputProduct();
					
				} catch (HulkStoreException e) {
					logger.error(e.getMessage());
				}
			}
		});
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnGuardar);

	}

	public String getTfProduct() {
		return tfProducto.getText();
	}

	public void setTfProduct(String tfProducto) {
		this.tfProducto.setText(tfProducto);
	}

	public String getTfOutputPrice() {
		return tfValorSalida.getText();
	}

	public void setTfOutputPrice(String tfValor) {
		this.tfValorSalida.setText(tfValor);
	}

	public String getTfOutputQuantity() {
		return tfCantidadSalida.getText();
	}

	public void setTfOutputQuantity(String tfCantidad) {
		this.tfCantidadSalida.setText(tfCantidad);
	}
	
	public void clear() {
		tfProducto.setText("");
		tfValorSalida.setText("");
		tfCantidadSalida.setText("");
	}

}
