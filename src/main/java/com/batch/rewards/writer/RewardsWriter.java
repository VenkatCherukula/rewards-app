/**
 * 
 */
package com.batch.rewards.writer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.batch.item.ItemWriter;

import com.batch.rewards.PurchaseItem;

/**
 * Rewards Writer
 *
 */
public class RewardsWriter implements ItemWriter<PurchaseItem> {

	@Override
	public void write(List<? extends PurchaseItem> items) throws Exception {

		System.out.println("Inside RewardsWriter");
		HashMap<Integer, Integer> customerRewardsMap = new HashMap<>(); 
		
		if (null != items) {
			items.stream().forEach(item -> {
			
			 Integer custId = 	item.getCustomerID();
			 
			 if (customerRewardsMap.containsKey(custId )) {
				 Integer tempRewards = 	customerRewardsMap.get(custId);
				 tempRewards = tempRewards + item.getRewards();
				 customerRewardsMap.put(custId, tempRewards);
			 }else {
				 customerRewardsMap.put(custId, item.getRewards());
			 }
			 
			 System.out.println("CustomerID: " + custId +  " CustomerName: " + item.getCustomerNa() + "  Purchase Item: " + item.getItemName() + " cost: " + item.getAmount() + " rewards earned: "+ item.getRewards() );
			
			});
		}

		
		if (null != customerRewardsMap) {
			for ( Map.Entry custMap  :customerRewardsMap.entrySet()) {
				System.out.println("CustomerID: "+custMap.getKey() + " Total Rewards: " + custMap.getValue());
				
			}
			
		
		}

	}

}
