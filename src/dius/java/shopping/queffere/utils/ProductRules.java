package dius.java.shopping.queffere.utils;

import java.util.HashMap;
import java.util.Map;

import dius.java.shopping.queffere.model.PricingRule;
import dius.java.shopping.queffere.model.Rule;

/**
 * Defining the ProductRules class, containing the static PricingRules for the required Products.
 * @author queffelec.regis@gmail.com
 *
 */
public class ProductRules {

	private static final PricingRule APPLE_TV_RULE = new PricingRule(StoreProducts.getAppleTv(), new Rule(3, 2));
	private static final PricingRule IPAD_RULE = new PricingRule(StoreProducts.getIpad(), new Rule(4, 499.99D));
	private static final PricingRule MACBOOK_PRO_RULE = new PricingRule(StoreProducts.getMacbookPro(), new Rule(StoreProducts.getVga()));
	
	private static final Map<String, PricingRule> PRICING_RULES = new HashMap<>();
	
	static {
		PRICING_RULES.put(APPLE_TV_RULE.getProduct().getSku(), APPLE_TV_RULE);
		PRICING_RULES.put(IPAD_RULE.getProduct().getSku(), IPAD_RULE);
		PRICING_RULES.put(MACBOOK_PRO_RULE.getProduct().getSku(), MACBOOK_PRO_RULE);
	}
	
	private ProductRules() {
		throw new IllegalStateException("Static utility class to store the shop product rules");
	}

	public static Map<String, PricingRule> getPricingRules() {
		return PRICING_RULES;
	}
}
