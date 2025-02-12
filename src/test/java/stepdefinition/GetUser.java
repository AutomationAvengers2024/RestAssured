package stepdefinition;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class GetUser {
	private RequestSpecification request;
	private Response response;
	private static final String BASE_URL = "https://userserviceapp-f5a54828541b.herokuapp.com";
	@Given("Admin is on the UserApi")
	public void admin_is_on_the_user_api() {
		RestAssured.baseURI = BASE_URL;
	}

	@Then("Admin sets Basic Authentication using the username {string} and password {string}")
	public void admin_sets_basic_authentication_using_the_username_and_password(String username, String password) {
		request = RestAssured.given().auth().preemptive().basic(username, password)
				.header("Content-Type", "application/json");
	}
	@Given("Admin creates GET request with valid endpoint {string}")
	public void admin_creates_get_request_with_valid_endpoints(String endpoint) throws Exception{
		request = request.when().log().all();
	}
	@When("Admin sends Get request with valid endpoint for all users")
	public void admin_sends_get_request_with_valid_endpoint_for_all_users() {
		response = request.get("/uap/users");
	}

	@Then("Admin receives {string} Status code")
	public void admin_receives_status_code(String string) {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}
	@Given("Admin creates Get request with invalid endpoint {string}")
	public void admin_creates_get_request_with_invalid_endpoint(String invalidendpoint) {
		request = request.when().log().all();
		response=request.get(invalidendpoint);
	}

	@When("Admin sends GET request with invalid endpoint")
	public void admin_sends_get_request_with_invalid_endpoint() {
		System.out.println(response.asPrettyString());
		System.out.println(response.getBody().asPrettyString());
	}

	@Then("Admin receives {int} not found status with response body")
	public void admin_receives_not_found_status_with_response_body(Integer int1) {
	int statuscode=response.getStatusCode();
	Assert.assertEquals(404, statuscode);
	System.out.println("Actual Status code"+statuscode);
	}
	@Given("Admin set the GET request with valid endpoint {string}")
	public void admin_set_the_get_request_with_valid_endpoint(String endpoint) {
	    request=request.when().log().all();
	    response=request.get(endpoint);
	}

	@When("Admin sends an HTTP GET request with the valid endpoint")
	public void admin_sends_an_http_get_request_with_the_valid_endpoint() {
		System.out.println(response.asPrettyString());
		System.out.println(response.getBody().asPrettyString());
	}

	@Then("Admin receives a {string} and  {string} status code")
	public void admin_receives_a_and_status_code(String statuscode, String statusline) {
	    
	}

}
