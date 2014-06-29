/**
 * 
 */
package com.restarent.controller.BestRestarent;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.restarent.controller.model.Meal;
import com.restarent.controller.util.Utils;

/**
 * @author ramakrishnak
 *
 */
public class BestChoiceController {
	public static String process(String inputFileName, List<String> searchItems){
		// Filter Items based on search criteria
		List<String> filteredData =  Utils.getFilteredInput(inputFileName, searchItems);

		// Create HotelWise Menu of Meals
		Map <Integer, Set<Meal>> rest_MealMap = MealMaker.createMenuMap(filteredData);

		// Make Combo Items and Select the Best Meal
		ValueMealMaker cb = new ValueMealMaker();
		String bestDeal = cb.getBestDeal(rest_MealMap, searchItems) ;
		return bestDeal;

	}	
}
