package Countries;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TallestCity {
	private static FileWriter file;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JSONObject result = new JSONObject();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\Shiko\\Desktop\\countries.json"))) {
		    String line;
		    while ((line = br.readLine()) != null) {
		    	if(line.contains("[")) {
		    		JSONObject country = new JSONObject();
		    		String c = line.replace("\"","");
		    		String CountryName = c.replace(": [", "").trim();
		    		String city;
		    		String maxCity = "";
		    		int numberOfCities = 0;
		    		while ((city = br.readLine()) != null) {
		    			if(!city.contains("]")) {
		    				numberOfCities++;
		    				if(city.length() > maxCity.length()) {
		    					String c1 = city.replace("\"","");
		    					maxCity = c1.replace(",", "").trim();
		    				}
		    			}
		    			else {
		    				System.out.println(numberOfCities);
		    				break;
		    			}
		    		}
		    		country.put("Number of cities",numberOfCities);
    				numberOfCities = 0;
		    		country.put("City with max length", maxCity);
		    		result.put(CountryName, country);
		    	}
		    }
		    file = new FileWriter("C:\\Users\\Shiko\\Desktop\\Cities.json");
		    file.write(result.toString());
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
