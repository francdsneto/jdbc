package br.com.caelum.jdbc.exception;

public class DAOException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6495188752527309225L;

	public DAOException(Exception e) {
		super(e);
	}
	
}
