package parsers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONParsers {
	final static String filePath = "src\\main\\resources\\parser.json";

	
	public static List<String> jsonParser() {
		List<String> cities = new ArrayList<String>();

		try {	
			FileReader reader = new FileReader(filePath);
			JSONParser jsonParser = new JSONParser();
			JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
			JSONArray citiesArr = (JSONArray) jsonObject.get("City");				
			for (int i = 0; i < citiesArr.size(); i++) {
				String city = (String) citiesArr.get(i);
				cities.add(city);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ee) {
			ee.printStackTrace();
		} catch (ParseException eee) {
			eee.printStackTrace();
		} catch (NullPointerException eeee) {
			eeee.printStackTrace();
		}
	//	System.out.println(cities);
		return null;
	}

}
