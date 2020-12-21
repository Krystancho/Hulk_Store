package com.nexos.hulkstore.controller;
import java.awt.EventQueue;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.nexos.hulkstore.view.FramePrincipal;
import com.nexos.hulkstore.controller.Main;
import com.nexos.hulkstore.util.GetProperties;

/**
 * Inicio Kardex
 * 
 * @author Carlos
 */
public class Main {

	private static Logger logger = Logger.getLogger(Main.class);
	
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				// Kardex manual
					String log4jConfPath = "resources\\log4j.properties";
					PropertyConfigurator.configure(log4jConfPath);
					logger.info("-- Inicio Kardex --");
					logger.info("Base Kardex: " + GetProperties.getInstance().getdataProperties("file_excel"));
	
					try {
						FramePrincipal frame = new FramePrincipal();
						frame.setVisible(true);
						
					} catch (Exception e) {
						//e.printStackTrace();
					}
				
				// Kardex automático desde otro frame para usuario
				//...
			}
		});
		
	}

}
