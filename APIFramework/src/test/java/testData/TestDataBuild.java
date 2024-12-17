package testData;

import java.util.ArrayList;
import java.util.List;

import payload.AddPlace;
import payload.Location;

public class TestDataBuild {

	public AddPlace addPlace(String name,String address,String language) {
		AddPlace sr = new AddPlace();
		sr.setAccuracy(50);
		sr.setAddress(address);
		sr.setLanguage(language);
		Location l = new Location();
		l.setLat(-38.383494);
		l.setLng(33.427362);
		sr.setLocation(l);
		sr.setName(name);
		sr.setPhone_number("(+91) 983 893 3937");
		sr.setWebsite("http://google.com");
		List<String> types = new ArrayList<String>();
		types.add("shoe park");
		types.add("shop");
		sr.setTypes(types);
		return sr;

	}
	public String deleteAPIPayload(String placeID) {
		
		return "{\r\n"
				+ "    \"place_id\":\""+placeID+"\"\r\n"
				+ "}";
	}
}
