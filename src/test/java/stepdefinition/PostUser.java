package stepdefinition;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;

import com.fasterxml.jackson.core.JsonProcessingException;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import userapi.request.userRequestBody;
import utilities.ConfigReader;
import utilities.ExcelReader;
import utilities.LoggerLoad;
public class PostUser {
	private String Userfirstname;
	private String Userlastname;
	private String Usercontactnumber;
	private String Useremailid;
	private String plotNumber;
	private String Street;
	private String State;
	private String Country;
	private String ZipCode;
	private int userid;
	private int addressid;
	private int expectedStatusCodeInt;
	private String expectedStatusCode;
	private Response response;
	private String request;
	
	@Given("Admin creates post request with valid data in request body from sheet name {string} and {int}")
	public void admin_creates_post_request_with_valid_data_in_request_body_from_sheet_name_and(String string, Integer rownumber) throws EncryptedDocumentException, IOException,IllegalArgumentException {
		//ExcelReader reader = new ExcelReader();
		List<LinkedHashMap<String, String>> dataFromExcel = ExcelReader.getExcelData(ConfigReader.getExcel(), "post");
		LinkedHashMap<String, String> userdata = dataFromExcel.get(rownumber -1); 
		Userfirstname = userdata.get("user_first_name");
		Userlastname = userdata.get("user_last_name");
		Usercontactnumber = userdata.get("user_contact_number");
		Useremailid = userdata.get("user_email_id");
		plotNumber = userdata.get("PlotNumber");
		Street = userdata.get("Street");
		State = userdata.get("state");
		Country = userdata.get("Country");
		ZipCode = userdata.get("zipCode");
		expectedStatusCode = userdata.get("status_code");
		System.out.println("Data Length");
		expectedStatusCodeInt = Integer.parseInt(expectedStatusCode);
	}

	@When("Admin sends post request with valid endpoint")
	public void admin_sends_post_request_with_valid_endpoint() throws JsonProcessingException {
		request =userRequestBody.postBody(Userfirstname,Userlastname,Usercontactnumber,Useremailid,plotNumber,Street,State,Country,ZipCode);
		
		response = RestAssured.given()
				.auth()
				.basic(ConfigReader.getUsername1(), ConfigReader.getPassword())
				.baseUri(ConfigReader.getUrl())
				.basePath(ConfigReader.CreateuserEndpoint())
				.contentType("application/json")
				.body(request)
				.when()
				.post();

	}

	@Then("Admin receives {int} created with response body")
	public void admin_receives_created_with_response_body(Integer int1) {
		int statusCode = response.getStatusCode();
		Assert.assertEquals(201, statusCode);
		LoggerLoad.info("Created New User Successfully");
	}

}
