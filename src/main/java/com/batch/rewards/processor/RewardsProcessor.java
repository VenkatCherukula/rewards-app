/**
 * 
 */
package com.batch.rewards.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

import com.batch.rewards.PurchaseItem;

/**
 * This class calculates rewards for each purchase item record.
 *
 */
public class RewardsProcessor implements ItemProcessor<PurchaseItem, PurchaseItem> {

	private static final Logger logger = LoggerFactory.getLogger(RewardsProcessor.class);
	private int purchaseLimitAmt1 = 50;
	private int purchaseLimitAmt2 = 100;
	
	
	@Override
	public PurchaseItem process(PurchaseItem item) throws Exception {
	
		if (null == item || item.getAmount() == null) {
			return null;
		}
		
		int rewards = 0;
		int amountAboveFiftyAndBelowHundred = 0;
		int amountAboveHundred = 0;
		
		logger.info("Inside RewardsProcessor process() method. item={}" , item.toString());
		
		PurchaseItem itemWithRewards = new PurchaseItem();
		itemWithRewards = item;
		int itemAmt = (int) Math.round(item.getAmount());
		
		//item price is > 50 && < 100
		/*
		 * if ( (itemAmt > purchaseLimitAmt1) && (itemAmt < purchaseLimitAmt2) ) {
		 * 
		 * rewards += itemAmt - purchaseLimitAmt1; }
		 */ 
		
//		if ( itemAmt > purchaseLimitAmt1 ) {
//		 	
//			rewards += itemAmt - purchaseLimitAmt1;
//		}
		
		if (itemAmt > purchaseLimitAmt2) {
			
			amountAboveFiftyAndBelowHundred = 50;
			amountAboveHundred = 	itemAmt - purchaseLimitAmt2;
			rewards += amountAboveFiftyAndBelowHundred + amountAboveHundred * 2;
		
		}else if ( itemAmt > purchaseLimitAmt1 ) {
			rewards += itemAmt - purchaseLimitAmt1;
		}

		
		System.out.println("rewards for each record" + rewards);
		
		itemWithRewards.setRewards(rewards);
		
		return itemWithRewards;
	}

}
