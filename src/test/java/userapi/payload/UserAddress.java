package userapi.payload;

public class UserAddress {
private String plotNumber;
private String Street;
private String state;
private String Country;
private String zipCode;

public UserAddress(String plotNumber,String street,String state,String Country,String zipCode) {
	this.plotNumber=plotNumber;
	this.Street=street;
	this.state=state;
	this.Country=Country;
	this.zipCode=zipCode;
	
}
public UserAddress()
{
}
public String getPlotNumber() {
		return plotNumber;
	}
public String getStreet() {
	return Street;
}
public String getState() {
	return state;
}
public String getCountry() {
	return Country;
}
public String getZipCode() {
	return zipCode;
}
public void setPlotNumber(String plotNumber) {
	this.plotNumber = plotNumber;
}
public void setStreet(String street) {
	this.Street = street;
}
public void setState(String state) {
	this.state = state;
}
public void setCountry(String country) {
	Country = country;
}
public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
}

}

