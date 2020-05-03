/**
 * 
 */
package com.batch.rewards;

import java.io.Serializable;

/**
 * Purchase item
 */
public class PurchaseItem implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Customer ID
	 */
	private Integer customerID;
	
	/**
	 * customer name
	 */
	private String customerNa;	
	
	/**
	 * item ID = unique
	 */
	private Integer itemID;
	
	/**
	 * item name
	 */
	private String itemName;

	/**
	 * item price
	 */
	private Integer quantity;
	
	/**
	 * item price
	 */
	private Double price;
	
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
	 * @return the itemID
	 */
	public Integer getItemID() {
		return itemID;
	}


	/**
	 * @param itemID the itemID to set
	 */
	public void setItemID(Integer itemID) {
		this.itemID = itemID;
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
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}


	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	
	/**
	 * @return the price
	 */
	public Double getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(Double price) {
		this.price = price;
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
