/**
 * 
 */
package com.restarent.controller.BestRestarent;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.restarent.controller.model.Meal;

/**
 * @author ramakrishnak
 *
 */
public class MealMaker {
	public static Map <Integer, Set<Meal>> createMenuMap(List<String> mealItems){
		Map <Integer, Set<Meal>> rMenu = new HashMap<Integer, Set<Meal>>() ;
		for(String item : mealItems){
			String[] items  = item.split(",");
			Meal meal = createMeal(items);

			Integer restID = new Integer(items[0]);
			if(rMenu.containsKey(restID)){
				Set<Meal> mealset = rMenu.get(restID) ;
				mealset.add(meal);
			}else{
				Set<Meal> mealset = new HashSet<Meal>();
				mealset.add(meal);
				rMenu.put(restID, mealset);
			}
		}
		return rMenu;
	}

	private static Meal createMeal(String[] items){
		Meal m = new Meal();
		for(int i=0;i<items.length;i++){
			switch(i){
				case 0 :
						m.setRestarentID(items[i]) ;
						break;
				case 1 :
						m.setPrice(items[i]);
						break;
				default:
						m.addItemToMeal(items[i]);
						break;
			}
		}
		return m;
	}
}
