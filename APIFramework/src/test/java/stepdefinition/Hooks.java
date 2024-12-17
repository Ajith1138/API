package stepdefinition;

import io.cucumber.java.Before;

public class Hooks {
	@Before("@DeleteApi")
	public void beforeScenario() throws Throwable {
		AddPlaceAPI step = new AddPlaceAPI();
		if (AddPlaceAPI.placeID==null) {
			step.add_place_pay_load_with("Sankar", "kondai", "Kannada");
			step.user_calls_with_http_request("addPlaceAPI","post");
			step.verify_place_id_created_maps_to_using("Sankar", "getPlaceAPI");
			
		}

	}

}
