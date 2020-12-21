package com.nexos.hulkstore.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import org.apache.log4j.Logger;
import com.nexos.hulkstore.exception.HulkStoreException;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;

/**
 * Panel de ingreso de nuevo producto.
 * 
 * @author Carlos
 *
 */
public class InputProductPanel extends JPanel {
	private static Logger logger = Logger.getLogger(InputProductPanel.class);
	private JTextField tfProducto;
	private JTextField tfValorEntrada;
	private JTextField tfCantidadEntrada;
	private FramePrincipal framePrincipal;

	public InputProductPanel(FramePrincipal framePrincipal) {
		this();
		this.framePrincipal = framePrincipal;
	}
	
	public InputProductPanel() {
		setForeground(new Color(0, 128, 0));
		setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Entradas", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		setLayout(new GridLayout(4, 2, 5, 5));
		
		JLabel lblProducto = new JLabel("Producto");
		add(lblProducto);
		
		tfProducto = new JTextField();
		add(tfProducto);
		tfProducto.setColumns(10);
		
		JLabel lblValorEntrada = new JLabel("Valor entrada");
		add(lblValorEntrada);
		
		tfValorEntrada = new JTextField();
		add(tfValorEntrada);
		tfValorEntrada.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		add(lblCantidad);
		
		tfCantidadEntrada = new JTextField();
		add(tfCantidadEntrada);
		tfCantidadEntrada.setColumns(10);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					framePrincipal.saveInputProduct();
					
				} catch (HulkStoreException e1) {
					logger.error(e1.getMessage());
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

	public String getTfInputPrice() {
		return tfValorEntrada.getText();
	}

	public void setTfInputPrice(String tfValorEntrada) {
		this.tfValorEntrada.setText(tfValorEntrada);
	}

	public String getTfInputQuantity() {
		return tfCantidadEntrada.getText();
	}

	public void setTfInputQuantity(String tfCantidadEntrada) {
		this.tfCantidadEntrada.setText(tfCantidadEntrada);
	}
	
	public void clear() {
		setTfProduct("");
		setTfInputPrice("");
		setTfInputQuantity("");
	}

}
