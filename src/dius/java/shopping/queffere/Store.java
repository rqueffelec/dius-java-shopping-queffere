package dius.java.shopping.queffere;

import dius.java.shopping.queffere.exceptions.ProductUnavailableException;
import dius.java.shopping.queffere.model.Checkout;
import dius.java.shopping.queffere.utils.ProductRules;
import dius.java.shopping.queffere.utils.StoreProducts;

/**
 * Defining the DIUS Store class.
 * @author queffelec.regis@gmail.com
 *
 */
public class Store {
	
	public static void main(String[] args) throws ProductUnavailableException {
		System.out.println("Client 1");
		
		checkoutOne();
		
		System.out.println("*****************");
		System.out.println("Client 2");
		
		checkoutTwo();
		
		System.out.println("*****************");
		System.out.println("Client 3");
		
		checkoutThree();
	}
	
	/**
	 * Checkout SKUs Scanned: atv, atv, atv, vga
	 * @throws ProductUnavailableException
	 */
	private static void checkoutOne() throws ProductUnavailableException {
		Checkout checkout = new Checkout(ProductRules.getPricingRules());
		
		checkout.scan(StoreProducts.getAppleTv().getSku());
		checkout.scan(StoreProducts.getAppleTv().getSku());
		checkout.scan(StoreProducts.getAppleTv().getSku());
		checkout.scan(StoreProducts.getVga().getSku());
		
		String total = checkout.total();
		
		System.out.println(new StringBuffer("SKUs Scanned: atv, atv, atv, vga - Total expected: $249.00 - Total returned: $")
			.append(total)
			.toString());
	}
	
	/**
	 * Checkout SKUs Scanned: atv, ipd, ipd, atv, ipd, ipd, ipd
	 * @throws ProductUnavailableException
	 */
	private static void checkoutTwo() throws ProductUnavailableException {
		Checkout checkout = new Checkout(ProductRules.getPricingRules());
		
		checkout.scan(StoreProducts.getAppleTv().getSku());
		checkout.scan(StoreProducts.getIpad().getSku());
		checkout.scan(StoreProducts.getIpad().getSku());
		checkout.scan(StoreProducts.getAppleTv().getSku());
		checkout.scan(StoreProducts.getIpad().getSku());
		checkout.scan(StoreProducts.getIpad().getSku());
		checkout.scan(StoreProducts.getIpad().getSku());
		
		String total = checkout.total();
		
		System.out.println(new StringBuffer("SKUs Scanned: atv, ipd, ipd, atv, ipd, ipd, ipd Total expected: $2718.95 - Total returned: $")
			.append(total)
			.toString());
	}
	
	/**
	 * Checkout SKUs Scanned: mbp, vga, ipd
	 * @throws ProductUnavailableException
	 */
	private static void checkoutThree() throws ProductUnavailableException {
		Checkout checkout = new Checkout(ProductRules.getPricingRules());
		
		checkout.scan(StoreProducts.getMacbookPro().getSku());
		checkout.scan(StoreProducts.getMacbookPro().getSku());
		checkout.scan(StoreProducts.getVga().getSku());
		checkout.scan(StoreProducts.getIpad().getSku());
		
		String total = checkout.total();
		
		System.out.println(new StringBuffer("SKUs Scanned: mbp, vga, ipd Total expected: $1949.98 - Total returned: $")
			.append(total)
			.toString());
	}
}
