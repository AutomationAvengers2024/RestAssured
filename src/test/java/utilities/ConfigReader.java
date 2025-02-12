package utilities;

	
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.io.InputStream;
	import java.util.Properties;
	
	public class ConfigReader {

	    private static Properties prop = new Properties();
  {
	        try {
	            InputStream inputStream = new FileInputStream("C:\\Users\\karth\\eclipse-workspace\\RestAssuredAPI\\src\\test\\resources\\config.properties");
	            prop.load(inputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	            throw new RuntimeException("NO Config File");
	        }
	    }
	    public static String getProperty(String key) {
	        return prop.getProperty(key);
	    }
	    public static String getUrl() {
	    	return getProperty("baseurl");
	    }
	    public static String getUsername1() {
	        return getProperty("username");
	    }
	    public static String getPassword() {
	        return getProperty("password");
	    }
	    public static String getAllUsersEndpoint() {
	        return getProperty("getallusers");
	    }
	    public static String getUserIdEndpoint() {
	        return getProperty("getuserid");
	    }
	    public static String getFirstNameEndpoint() {
	        return getProperty("getuserfirstname");
	    }
	    public static String CreateuserEndpoint() {
	        return getProperty("postuser");
	    }
	    public static String PutEndpoint() {
	        return getProperty("putuser");
	    }
	    public static String getDeleteEndpoint() {
	        return getProperty("deleteuser");
	    }
	    public static String getExcel() {
	        return getProperty("excelpath");
	        }
		
		
	    
	}
