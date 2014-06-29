/**
 * 
 */
package com.restarent.controller.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ramakrishnak
 *
 */
public class Meal {
	private Float price ;
	private Set<String> items;
	private int restarentID;

	public Meal() {
		
	}

	public boolean containsItem(String dish){
		return items.contains(dish.trim());
	}

	public boolean containsAllItems(Set<String> dishes){
		return items.containsAll(dishes) ;
	}

	public Float getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = new Float(price);
	}
	public Set<String> getItems() {
		return items;
	}
	public void setItems(Set<String> items) {
		this.items = items;
	}
	public void addItemToMeal(String s){
		if(items == null)
			items = new HashSet<String>();
		items.add(s.trim());

	}
	public int getRestarentID() {
		return restarentID;
	}
	public void setRestarentID(String hotelID) {
		this.restarentID = Integer.parseInt(hotelID);
	}

	@Override
	public int hashCode() {
		return items.hashCode()+restarentID+price.hashCode();
	}

	@Override
	public boolean equals(Object arg0) {
		if(arg0 instanceof Meal){
			Meal meal = (Meal)arg0;
			return ( (meal.getItems().equals(this.items)) && (meal.getRestarentID() == this.restarentID)&& (meal.getPrice().equals(this.getPrice())));
		}
		return false;
	}

	@Override
	public String toString() {
		return "{ id:"+restarentID+" ,price:"+price+" , items:"+items.toString()+ "}";
	}
}
