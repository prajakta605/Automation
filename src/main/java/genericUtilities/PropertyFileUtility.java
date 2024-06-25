package genericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileUtility {
public String readDataFromPf(String key) throws Throwable {
	//FileInputStream fis=new FileInputStream("C:\\Users\\ABHISHEK\\OneDrive\\Documents\\eclipse\\Advancedselenium\\src\\test\\resources\\commondata.properties");
	FileInputStream fis=new FileInputStream(IconstantUtility.propertypath);
	Properties p=new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
}
}
