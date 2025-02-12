package stepdefinition;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import userapi.payload.UserPayload;
import userapi.request.userRequestBody;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;

public class PutUser {
	private String userFirstName;
	private String userLastName;
	private String userContactNumber;
	private String userEmailId;
	private String plotNumber;
	private String street;
	private String state;
	private String country;
	private String zipCode;
	private Response response;
	private int expectedStatusCodeInt;
	private String expectedStatusCode;
	private String requestBody;
	int userId = UserPayload.getUser_id();
	
	@Given("Admin has a valid\\/invalid request body for put operation from sheet name {string} at row number {int}")
	public void admin_has_a_valid_invalid_request_body_for_put_operation_from_sheet_name_at_row_number(String string, Integer int1) throws EncryptedDocumentException, IOException {
		
				List<LinkedHashMap<String, String>> dataFromExcel = ExcelReader.getExcelData(ConfigReader.getExcel(), "Putdata");
				LinkedHashMap<String, String> userData = dataFromExcel.get(int1 - 1);  

				
				userFirstName = userData.get("user_first_name");
				userLastName = userData.get("user_last_name");
				userContactNumber = userData.get("user_contact_number");
				userEmailId = userData.get("user_email_id");
				plotNumber = userData.get("PlotNumber");
				street = userData.get("Street");
				state = userData.get("state");
				country = userData.get("Country");
				zipCode = userData.get("zipCode");

				
				//expectedStatusCode = userData.get("status_code");
				//expectedStatusCodeInt = Integer.parseInt(expectedStatusCode);    	
	
	
	}
	@When("Admin sends a PUT request to the valid endpoint")
	public void admin_sends_a_put_request_to_the_valid_endpoint() throws JsonProcessingException {
		requestBody = userRequestBody.postBody(userFirstName, userLastName, userContactNumber, 
				userEmailId, plotNumber, street, state, country, zipCode);

		response = RestAssured.given()
				.auth().preemptive()
				.basic(ConfigReader.getUsername1(), ConfigReader.getPassword())
				.baseUri(ConfigReader.getUrl())
				.contentType("application/json")
				.body(requestBody)
				.when()
				.put("uap/updateuser/"+userId);
	}
	@Then("The API should return corresponding status code")
	public void the_api_should_return_corresponding_status_code() {
		LoggerLoad.info("200 Status code");

	}
}
