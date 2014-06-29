/**
 * 
 */
package com.restarent.controller.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ramakrishnak
 *
 */
public class Utils {
	public static  List<String> getFilteredInput(String fileName , List<String> keyWords ){

		  List<String> matchItems =   new ArrayList<String>();
			File file = new File(fileName);
			FileInputStream fstream;

			try {
				fstream = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
				String strLine;
				while ((strLine = br.readLine()) != null)   {
				  if(isItemExist(strLine, keyWords)){
					  populateMap(matchItems ,strLine);
				  }
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
			return matchItems;
		}


		public static boolean isItemExist(String line , List<String>keywords){
			for(String key:keywords){
				if(line.contains(key.trim()))
					return true;
			}
			return false;
		}


		/**
		 * Populates the map with items in the Search Query.
		 * @param relatedItems
		 */
		public static void populateMap( List<String> relatedItems , String strLine){
			relatedItems.add(strLine);
		}
}
