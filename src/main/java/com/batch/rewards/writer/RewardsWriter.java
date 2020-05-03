/**
 * 
 */
package com.batch.rewards.writer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import com.batch.rewards.PurchaseItem;

/**
 * Rewards Writer
 *
 */
public class RewardsWriter implements ItemWriter<PurchaseItem> {

	private final Logger logger = LoggerFactory.getLogger(RewardsWriter.class);
	
	private String month = "";
	private int monthlyRewards = 0;
	private String prevCustomerName = "";
	private int prevCustomerID = 0;
	
	@Override
	public void write(List<? extends PurchaseItem> items) throws Exception {

		HashMap<Integer, Integer> custTotalRewardsMap = new HashMap<>(); 
		
		if (null != items) {
			
			logger.info("**** Monthly rewards for each customer ***");

			items.stream().forEach(item -> {
			
			 int custId = 	item.getCustomerID();

			 /**
			  * Calculate monthly rewards
			  */
			 String[] dateArray = item.getDate().split("/");

			 
			 /**
			  * Calculate total rewards for each Customer.
			  */
			 if (custTotalRewardsMap.containsKey(custId )) {
				 Integer tempRewards = 	custTotalRewardsMap.get(custId);
				 tempRewards = tempRewards + item.getRewards();
				 custTotalRewardsMap.put(custId, tempRewards);
				 
				 /** 
				  * compare month with same 
				  */
				 if (month.equalsIgnoreCase(dateArray[0])  ) {
					 monthlyRewards +=  item.getRewards();
				 }else {
					 if ( !month.isEmpty() ) {
						 logger.info("CustomerID: " + prevCustomerID +  " CustomerName: " + prevCustomerName + " month: " + month +  " rewards earned: "+ monthlyRewards );					 
					 }

					 month = dateArray[0]; //assign month
					 monthlyRewards =item.getRewards(); //assign rewards to monthly rewards amount.
				 }
				 
				 
			 }else {
				 custTotalRewardsMap.put(custId, item.getRewards());  // add total rewards for customer id
				 
				 // monthly rewards calculation
				 if ( !month.isEmpty() ) {
					 logger.info("CustomerID: " + prevCustomerID +  " CustomerName: " + prevCustomerName + " month: " + month +  " rewards earned: "+ monthlyRewards );					 
				 }
				 
				 month = dateArray[0]; //assign month
				 monthlyRewards =item.getRewards(); //assign rewards to monthly rewards amount.
				 prevCustomerID = item.getCustomerID();
				 prevCustomerName = item.getCustomerNa();
				 
			 }
			 
			 
			 //logger.info("************ Display each Purchage Record with Rewards *********** ");
			 //logger.info("CustomerID: " + custId +  " CustomerName: " + item.getCustomerNa() + " Item ID: " + item.getItemID() + " Item Name : " + item.getItemName() + " quantity: " + item.getQuantity() + " price: " + item.getPrice() + " rewards earned: "+ item.getRewards() );
			 
			});
		
			 // display final monthly rewards if available
			 if ( !month.isEmpty() ) {
				 logger.info("CustomerID: " + prevCustomerID +  " CustomerName: " + prevCustomerName + " month: " + month +  " rewards earned: "+ monthlyRewards );					 
			 }
			
		}


		logger.info("************ Display total rewards for each Customer *********** ");

		if (null != custTotalRewardsMap) {
						
			for ( Map.Entry custMap  :custTotalRewardsMap.entrySet()) {

				logger.info("CustomerID: "+custMap.getKey() + "   Total Rewards: " + custMap.getValue());
				
			}
		}

	}

}
