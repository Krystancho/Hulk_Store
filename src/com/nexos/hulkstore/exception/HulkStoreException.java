/**
 * 
 */
package com.nexos.hulkstore.exception;

/**
 * @author Carlos
 *
 */
@SuppressWarnings("serial")
public class HulkStoreException extends Exception{

	public HulkStoreException() {
		
	}

	/**
	 * Recibe texto error a mostrar
	 * @param message
	 */
	public HulkStoreException(String message) {
		super(message);
	}

}
