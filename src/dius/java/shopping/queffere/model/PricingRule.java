package dius.java.shopping.queffere.model;

/**
 * Defining the PricingRule class.
 * @author queffelec.regis@gmail.com
 *
 */
public class PricingRule {

	private Product product;
	private Rule rule;
	
	/**
	 * Defining the default constructor
	 */
	public PricingRule() {
		// Default PricingRule constructor
	}
	
	/**
	 * Defining the PricingRule constructor to initialize all required PricingRule properties
	 * @param product
	 * @param rule
	 */
	public PricingRule(Product product, Rule rule) {
		this.product = product;
		this.rule = rule;
	}
	
	public Product getProduct() {
		return product;
	}

	public Rule getRule() {
		return rule;
	}

	/**
	 * Applying a rule to a product, according to the rule type, to calculate the total cart cost for a specific product.
	 * @param quantity
	 * @return Double
	 */
	public Double apply(Integer quantity) {
		Double total = 0D;
		
		switch (rule.getType()) {
			case DEAL:
				total += quantity % rule.getPurchased() == 0 ? product.getPrice() * rule.getPaid() * Double.valueOf((quantity / rule.getPurchased())) 
					: ((product.getPrice() * (quantity % rule.getPurchased())) + (product.getPrice() * rule.getPaid() * Double.valueOf((quantity / rule.getPurchased()))));
				break;
			case DISCOUNT:
				total += quantity > rule.getPurchased() ? rule.getReducedPrice() * quantity : product.getPrice() * quantity;
				break;
			default:
				total += product.getPrice() * quantity;
				break;
			}
		
		return total;
	}
}
