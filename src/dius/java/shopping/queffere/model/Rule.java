package dius.java.shopping.queffere.model;

/**
 * Defining the Rule class.
 * @author queffelec.regis@gmail.com
 *
 */
public class Rule {

	private RuleType type;
	
	private Product freeProduct;
	
	private Integer purchased;
	
	private Integer paid;
	
	private Double reducedPrice;
	
	/**
	 * Defining the default constructor
	 */
	public Rule() {
		// Default Rule constructor
	}

	/**
	 * Defining the Rule constructor to initialize the required Rule properties related 
	 * to a FREE_PRODUCT RuleType
	 * @param freeProduct
	 */
	public Rule(Product freeProduct) {
		this.type = RuleType.FREE_PRODUCT;
		this.freeProduct = freeProduct;
	}

	/**
	 * Defining the Rule constructor to initialize the required Rule properties related 
	 * to a DEAL RuleType
	 * @param purchased
	 * @param paid
	 */
	public Rule(Integer purchased, Integer paid) {
		this.type = RuleType.DEAL;
		this.purchased = purchased;
		this.paid = paid;
	}

	/**
	 * Defining the Rule constructor to initialize the required Rule properties related 
	 * to a DISCOUNT RuleType
	 * @param purchased
	 * @param reducedPrice
	 */
	public Rule(Integer purchased, Double reducedPrice) {
		this.type = RuleType.DISCOUNT;
		this.purchased = purchased;
		this.reducedPrice = reducedPrice;
	}

	public RuleType getType() {
		return type;
	}

	public void setType(RuleType type) {
		this.type = type;
	}

	public Product getFreeProduct() {
		return freeProduct;
	}

	public void setFreeProduct(Product freeProduct) {
		this.freeProduct = freeProduct;
	}

	public Integer getPurchased() {
		return purchased;
	}

	public void setPurchased(Integer purchased) {
		this.purchased = purchased;
	}

	public Integer getPaid() {
		return paid;
	}

	public void setPaid(Integer paid) {
		this.paid = paid;
	}

	public Double getReducedPrice() {
		return reducedPrice;
	}

	public void setReducedPrice(Double reducedPrice) {
		this.reducedPrice = reducedPrice;
	}
}
