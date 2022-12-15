package dius.java.shopping.queffere.model;

import java.io.Serializable;

/**
 * Defining the Product class
 * @author queffelec.regis@gmail.com
 *
 */
public class Product implements Serializable {

	private static final long serialVersionUID = 7911670845101006702L;

	private String sku;
	
	private String name;
	
	private Double price;
	
	/**
	 * Defining the default constructor
	 */
	public Product() {
		// Default Product constructor
	}

	/**
	 * Defining the Product constructor to initialize all required Product properties
	 * @param sku
	 * @param name
	 * @param price
	 */
	public Product(String sku, String name, Double price) {
		this.sku = sku;
		this.name = name;
		this.price = price;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}
}
