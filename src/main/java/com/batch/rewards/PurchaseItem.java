/**
 * 
 */
package com.batch.rewards;

import java.io.Serializable;

/**
 * Purchase item
 */
public class PurchaseItem {

	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;

	/**
	 * Customer ID
	 */
	private Integer customerID;
	
	/**
	 * customer name
	 */
	private String customerNa;	
	
	/**
	 * item name
	 */
	private String itemName;
	
	/**
	 * item price
	 */
	private Double amount;
	
	/**
	 * purchase date 
	 */
	private String date;
	
	/**
	 * rewards
	 */
	private Integer rewards;

	
	public PurchaseItem() {
		
	}


	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}


	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}


	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}


	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}


	/**
	 * @return the date
	 */
	public String getDate() {
		return date;
	}


	/**
	 * @param date the date to set
	 */
	public void setDate(String date) {
		this.date = date;
	}


	/**
	 * @return the customerID
	 */
	public Integer getCustomerID() {
		return customerID;
	}


	/**
	 * @param customerID the customerID to set
	 */
	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}


	/**
	 * @return the customerNa
	 */
	public String getCustomerNa() {
		return customerNa;
	}


	/**
	 * @param customerNa the customerNa to set
	 */
	public void setCustomerNa(String customerNa) {
		this.customerNa = customerNa;
	}


	/**
	 * @return the rewards
	 */
	public Integer getRewards() {
		return rewards;
	}


	/**
	 * @param rewards the rewards to set
	 */
	public void setRewards(Integer rewards) {
		this.rewards = rewards;
	}
	
	


}
