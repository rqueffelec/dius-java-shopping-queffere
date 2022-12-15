package dius.java.shopping.queffere.utils;

import java.util.HashMap;
import java.util.Map;

import dius.java.shopping.queffere.model.Product;

/**
 * Defining the StoreProducts class, containing the static Products.
 * @author queff
 *
 */
public class StoreProducts {

	private static final Product IPAD = new Product("ipd", "Super iPad", 549.99D);
	private static final Product MACBOOK_PRO = new Product("mbp", "MacBook Pro", 1399.99D);
	private static final Product APPLE_TV = new Product("atv", "Apple TV", 109.50D);
	private static final Product VGA = new Product("vga", "VGA adapter", 30.00D);
	
	private static final Map<String, Product> STORE_PRODUCTS = new HashMap<>();
	
	static {
		STORE_PRODUCTS.put(IPAD.getSku(), IPAD);
		STORE_PRODUCTS.put(MACBOOK_PRO.getSku(), MACBOOK_PRO);
		STORE_PRODUCTS.put(APPLE_TV.getSku(), APPLE_TV);
		STORE_PRODUCTS.put(VGA.getSku(), VGA);
	}
	
	private StoreProducts() {
		throw new IllegalStateException("Static utility class to store the shop products");
	}
	
	public static Product getIpad() {
		return IPAD;
	}

	public static Product getMacbookPro() {
		return MACBOOK_PRO;
	}

	public static Product getAppleTv() {
		return APPLE_TV;
	}

	public static Product getVga() {
		return VGA;
	}

	public static Map<String, Product> getStoreProducts() {
		return STORE_PRODUCTS;
	}
}
