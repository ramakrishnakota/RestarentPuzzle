/**
 * 
 */
package com.restarent.controller.BestRestarent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.restarent.controller.model.Meal;

/**
 * @author ramakrishnak
 *
 */
public class ValueMealMaker {
	private  List<String> searchItems; 

	private float minimumPrice = Float.MAX_VALUE ;
	private int mId = -1;


	public String getBestDeal(Map <Integer, Set<Meal>> restMealMap , List<String> sItems){
		String returnString = "Nil";
		this.searchItems = sItems;

		Iterator<Integer> itr = restMealMap.keySet().iterator();
		while(itr.hasNext()){
			List<Meal> restMenu = new ArrayList<Meal>(restMealMap.get(itr.next()));
			getBestMeal(restMenu);
		}

		if( mId > 0){
			returnString =mId+", "+minimumPrice ;
			return returnString;
		}

		return returnString;
	}


	private void getBestMeal(List<Meal> menu){
		int mSize = 1 << menu.size(); 
		//System.out.println("menus"+menu.size()+" and cominations "+numOfCombos);
		 for(int i = 0; i < mSize; i++) {

			 int pos = menu.size() - 1;
			 int bitmask = i;

			   List<Integer> indicesRemaining = new ArrayList<Integer>(searchItems.size());
			   for(int j =0 ; j<searchItems.size();j++ ){
				   indicesRemaining.add(j);
			   }

			   float price = 0;
			   int restId = 0;

			   while(bitmask > 0)	 {
					if((bitmask & 1) == 1){
						Meal meal = menu.get(pos);
						restId= meal.getRestarentID();
						price += meal.getPrice();

						if (indicesRemaining.size() > 0){
							Iterator< Integer> itr = indicesRemaining.iterator();
							while(itr.hasNext()){
								if(meal.containsItem(searchItems.get(itr.next()))){
									itr.remove();
								}
							}
						}
				    }
				    bitmask >>= 1;
				    pos--;
			   }

			   if(indicesRemaining.size() == 0 && price < minimumPrice){
				   minimumPrice = price;
				   mId = restId;
			   }
		 }
	}
}
