package com.nexos.hulkstore.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import com.nexos.hulkstore.exception.HulkStoreException;
/**
 * 
 * @author Carlos
 *
 */
public class GetProperties {
	private static Logger logger = Logger.getLogger(GetProperties.class);
	private static Properties properties = new Properties();

	private static GetProperties instanceGetProperties = null;

	/**
	 * @throws HulkStoreException
	 * @throws IOException
	 */
	private GetProperties() throws HulkStoreException, IOException {

		File file = new File("resources\\properties");

		InputStream fileInputStream;

		if (file.exists()) {
			fileInputStream = new FileInputStream(file);
		} else {
			fileInputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("properties");

			if (fileInputStream == null) {
				throw new HulkStoreException("No se encontr� ");
			}
		}

		properties.load(fileInputStream);
	}

	/**
	 * Devuelve el valor de la variable del properties
	 * 
	 * @param name
	 * @return
	 */
	public String getdataProperties(String name) {
		return properties.getProperty(name);
	}

	public static GetProperties getInstance() {

		if (instanceGetProperties == null) {
			try {
				instanceGetProperties = new GetProperties();
			} catch (HulkStoreException e) {
				logger.error(e.getMessage());
			} catch (IOException e) {
				logger.error(e.getMessage());
			}
		}

		return instanceGetProperties;
	}
}
