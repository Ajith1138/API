package stepdefinition;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testData.APIResources;
import testData.TestDataBuild;
import utils.Utility;

public class AddPlaceAPI extends Utility {
	RequestSpecification res;
	Response response;
	TestDataBuild testData = new TestDataBuild();
	static String placeID;
	
	@Given("Add place PayLoad with {string} {string} {string}")
	public void add_place_pay_load_with(String name, String address, String language) throws Throwable {
		res = given().spec(requestSpecification()).
				body(testData.addPlace(name,address,language));

		
	}


	@When("user calls {string} with {string} http request")
	public void user_calls_with_http_request(String resouce, String method) {
		APIResources apiResource = APIResources.valueOf(resouce);
		String resource = apiResource.getResource();
		System.out.println(resource);
		if (method.equalsIgnoreCase("POST")) {
			response = res.when().post(resource);
		}
		else if (method.equalsIgnoreCase("GET")) {
			response = res.when().get(resource);
		}
		
		else if (method.equalsIgnoreCase("PUT")) {
			response = res.when().put(resource);
		} 
		
		else if (method.equalsIgnoreCase("DELETE")) {
			response = res.when().delete(resource);
		} 

	}

	@Then("Api call got sucess with status code {int}")
	public void api_call_got_sucess_with_status_code(int int1) {
		assertEquals(response.getStatusCode(), int1);

	}

	@Then("{string} in response body is {string}")
	public void in_response_body_is(String key, String value) {
		assertEquals(Utility.getJsonPath(response, key), value);

	}
	
	@Then("Verify Place id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String name, String resource) throws Throwable {
		placeID = Utility.getJsonPath(response, "place_id");
		res = given().spec(requestSpecification()).queryParam("place_id", placeID);
		user_calls_with_http_request(resource, "GET");
		String actualName = Utility.getJsonPath(response, "name");
		assertEquals(actualName, name);
	}
	
	@Given("Add Deleteplace PayLoad")
	public void add_deleteplace_pay_load() throws Throwable {
		res = given().spec(requestSpecification()).
				body(testData.deleteAPIPayload(placeID));
	    
	}

}
