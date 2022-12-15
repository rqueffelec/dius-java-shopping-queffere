package dius.java.shopping.queffere.model;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import dius.java.shopping.queffere.exceptions.ProductUnavailableException;
import dius.java.shopping.queffere.utils.StoreProducts;

/**
 * Defining the Checkout class.
 * @author queffelec.regis@gmail.com
 *
 */
public class Checkout {

	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("0.00");
	
	private static final Map<String, Product> STORE_PRODUCTS = StoreProducts.getStoreProducts();
	
	private Map<String, PricingRule> pricingRules;
	private Map<String, Integer> cart;
	
	/**
	 * Defining the default constructor
	 */
	public Checkout() {
		// Default Checkout constructor
	}

	/**
	 * Defining the Checkout constructor to initialize all required Checkout properties
	 * @param pricingRules
	 */
	public Checkout(Map<String, PricingRule> pricingRules) {
		this.pricingRules = pricingRules;
		this.cart = new HashMap<>();
	}
	
	/**
	 * Scan one product according to its sku and add it to the cart.
	 * Throwing the appropriate exception if the product does not exist in the store.
	 * @param sku
	 * @throws ProductUnavailableException
	 * @return
	 */
	public void scan(String sku) throws ProductUnavailableException {
		if(!STORE_PRODUCTS.containsKey(sku)) {
			throw new ProductUnavailableException(new StringBuilder("The product ")
				.append(sku)
				.append(" is unavailable in our store")
				.toString());
		}
		
		cart.put(sku, cart.containsKey(sku) ? cart.get(sku) + 1 : 1);
		
		System.out.println(new StringBuilder("Item scanned: ")
			.append(sku)
			.append(" - Cart quantity: ")
			.append(cart.get(sku))
			.toString());
	}
	
	/**
	 * Get the cart total amount, applying the pricing rules as required.
	 * @return String
	 */
	public String total() {
		Double total = 0D;
		
		for(Map.Entry<String, Integer> entry : cart.entrySet()) {
			Optional<PricingRule> pricingRule = pricingRules.entrySet().stream()
				.filter(r -> entry.getKey().equalsIgnoreCase(r.getKey()))
				.map(Map.Entry::getValue)
				.findFirst();
			
			if(pricingRule.isPresent()) {
				PricingRule rule = pricingRule.get();
				Integer quantity = entry.getValue();
				Product freeProduct = rule.getRule().getFreeProduct();
				
				total += rule.apply(quantity);
				
				if(rule.getRule().getType() == RuleType.FREE_PRODUCT  && freeProduct != null && cart.containsKey(freeProduct.getSku())) {
					Integer freeProductQuantity = cart.get(freeProduct.getSku());
					
					total -= quantity <= freeProductQuantity ? freeProduct.getPrice() * quantity 
						: freeProduct.getPrice() * freeProductQuantity;
				}
			}else {
				total += entry.getValue() * STORE_PRODUCTS.get(entry.getKey()).getPrice();
			}
		}
		
		return DECIMAL_FORMAT.format(total);
	}
}
