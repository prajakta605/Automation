package VtigerTC;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebdriverUtility;
import objectRepositories.CreateNewOrganizationPage;
import objectRepositories.HomePage;
import objectRepositories.LoginPage;
import objectRepositories.OrganizationInfoPage;
import objectRepositories.OrganizationPage;

public class CreateOrgTest {
	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		PropertyFileUtility putil=new PropertyFileUtility();
		ExcelFileUtility eutil=new ExcelFileUtility();
		WebdriverUtility wutil=new WebdriverUtility();
		JavaUtility jutil=new JavaUtility();
		//fetch browser name
		String BROWSER = putil.readDataFromPf("browser");
		System.out.println(BROWSER);
		//Launch browser
		if(BROWSER.equals("edge")) {
			 driver=new EdgeDriver();
		}
		else if(BROWSER.equals("chrome")) {
			 driver=new ChromeDriver();
		}
		else if(BROWSER.equals("firefox")) {
			 driver=new FirefoxDriver();
		}
		else {
			System.out.println("INVALID BROWSER NAME");
		}
		wutil.maximizeWindow(driver);
		wutil.waitForPageLoad(driver);
		//fetch URL
		String URL = putil.readDataFromPf("url");
		driver.get(URL);
		//Login to app
		String UN = putil.readDataFromPf("un");
		String PWD = putil.readDataFromPf("pwd");
		//Create object of Login apge POM class
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(UN, PWD);
		//Create Object of Homepage
		HomePage h=new HomePage(driver);
		h.clickOnOrganizationLink();
		//click on OrgLookup img
		OrganizationPage op=new OrganizationPage(driver);
		op.clickonCreateOrgLookUpImg();
		//give org name
		String orgname = eutil.readDatafromExcel("Sheet1", 0, 0);
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(orgname);
		//click on save Btn
		cnop.getSaveBtn();
		//create object of OrganizationInfoPage
		OrganizationInfoPage oip=new OrganizationInfoPage(driver);
		String header = oip.getHeader();
		if(header.contains(orgname)) {
			System.out.println("Org is created and TC is pass");
		}
		else {
			System.out.println("TC is failed");
		}
		//logout from app
		h.logOutOfApp(driver);
		System.out.println("Hii This is change made by TL from github");
		}
	}
