package userapi.request;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import userapi.payload.UserAddress;
import userapi.payload.UserPayload;
import utilities.LoggerLoad;

public class userRequestBody {
	 public static UserPayload userpayload=new UserPayload();
	 public static UserAddress userAddress=new UserAddress();
public static String  postBody(String userFirstName, String userLastName, String userContactNumber, String userEmailId, 
        String plotNumber, String street, String state, String country, String zipCode) 
        throws JsonProcessingException  {
    UserPayload userpayload=new UserPayload();
	userpayload.setUser_first_name(userFirstName);
	userpayload.setUser_last_name(userLastName);
	userpayload.setUser_contact_number(userContactNumber);
	userpayload.setUser_email_id(userEmailId);
	UserAddress userAddress=new UserAddress();
	userAddress.setPlotNumber(plotNumber);
	userAddress.setStreet(street);
	userAddress.setState(state);
	userAddress.setCountry(country);
	userAddress.setZipCode(zipCode);
	userpayload.setUserAddress(userAddress);
	ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(userAddress);
}
public static String postBody(String userFirstName,String userLastName, String userContactNumber, String userEmailId) throws JsonProcessingException{
	UserPayload userpayload=new UserPayload();
	userpayload.setUser_first_name(userFirstName);
	userpayload.setUser_last_name(userLastName);
	userpayload.setUser_contact_number(userContactNumber);
	userpayload.setUser_email_id(userEmailId);
	ObjectMapper objectMapper = new ObjectMapper();
    return objectMapper.writeValueAsString(userAddress);
  
}
}
