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
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;
import com.nexos.hulkstore.exception.HulkStoreException;

/**
 * Panel de búsqueda de producto.
 * 
 * @author Carlos
 *
 */
public class SearchProductPanel extends JPanel {
	private static Logger logger = Logger.getLogger(SearchProductPanel.class);
	private JTextField tfproducto;
	private FramePrincipal framePrincipal;

	public SearchProductPanel(FramePrincipal framePrincipal) {
		this();
		this.framePrincipal = framePrincipal;
	}
	
	public SearchProductPanel() {
		setBorder(new TitledBorder(null, "Buscar producto", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 128, 0)));
		setLayout(new GridLayout(2, 2, 5, 5));
		
		JLabel lblProducto = new JLabel("Producto");
		lblProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblProducto.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(lblProducto);
		
		tfproducto = new JTextField();
		tfproducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					framePrincipal.searchProduct();
					
				} catch (HulkStoreException e1) {
					logger.error(e1.getMessage());
				}
			}
		});
		add(tfproducto);
		tfproducto.setColumns(10);
		
		JLabel lblvoid1 = new JLabel("");
		add(lblvoid1);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					framePrincipal.searchProduct();
					
				} catch (HulkStoreException e1) {
					logger.error(e1.getMessage());
				}
			}
		});
		btnBuscar.setFont(new Font("Tahoma", Font.BOLD, 11));
		add(btnBuscar);
	}

	public String getTfproducto() {
		return tfproducto.getText();
	}

	public void setTfproducto(String tfproducto) {
		this.tfproducto.setText(tfproducto);
	}
	
	public void clear() {
		tfproducto.setText("");
	}

}
