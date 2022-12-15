package dius.java.shopping.queffere.exceptions;

/**
 * Defining the custom ProductUnavailableException.
 * @author queffelec.regis@gmail.com
 *
 */
public class ProductUnavailableException extends Exception {

	private static final long serialVersionUID = -9074048460168563591L;

	public ProductUnavailableException(String message) {
		super(message);
	}
}
