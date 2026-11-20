package data;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class dataReader {

	public List<HashMap<String, String>> getJsonDataToMap() throws IOException {

			// read JSON to string
		String jsonContent = FileUtils.readFileToString(
				new File(System.getProperty("user.dir") + "//src//test//java//data//PurchaseOrder.json"), "UTF-8");

		// String to hashMap Jacson databind
		ObjectMapper mapper= new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>()
		{
		});
		return data;
		
		//{map, map1}
		
		
	}

}
