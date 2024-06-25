package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class StaleelementRefException {
public static void main(String[] args) {
	WebDriver driver=new EdgeDriver();
	driver.get("https://www.saucedemo.com");
	//xpath for UN  //1010
	WebElement UN = driver.findElement(By.xpath("//input[@id='user-name']"));
	//refresh the page
	driver.navigate().refresh();  //2020
	//use sendkeys method
	UN.sendKeys("admin");
}
}
