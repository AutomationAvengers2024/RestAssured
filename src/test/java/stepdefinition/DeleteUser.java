package stepdefinition;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import userapi.payload.UserPayload;
import utilities.ConfigReader;

public class DeleteUser {
	private Response response;
	private int userId;
	private String userName;
	@Given("Admin creates the DELETE request with valid UserID endpoint")
	public void admin_creates_the_delete_request_with_valid_user_id_endpoint() {
		userId=UserPayload.getUser_id();
	}

	@When("Admin sends Delete request with valid endpoint and valid userid")
	public void admin_sends_delete_request_with_valid_endpoint_and_valid_userid() {
		response = RestAssured.given()
		        .auth()
		        .basic(ConfigReader.getUsername1(), ConfigReader.getPassword()) 
		        .baseUri(ConfigReader.getUrl()) 
		        .basePath("uap/deleteuser/"+userId) 		         
		        .when()
		        .delete();
	}

	@Then("Admin receives {int} OK status")
	public void admin_receives_ok_status(Integer int1) {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);
	}



}
