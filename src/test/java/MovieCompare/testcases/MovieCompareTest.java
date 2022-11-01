package MovieCompare.testcases;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import MovieCompare.base.TestBase;
//import MovieCompare.util.TestUtil;



public class MovieCompareTest extends TestBase {

	public static String countryWiki, countryIMDB, releaseWiki, releaseIMDB;

	@BeforeTest
	public void getAndStoreData() throws InterruptedException{

		driver.get(config.getProperty("website1"));
		//type("searchWiki_XPATH", searchMovie_var);
		driver.findElement(By.xpath(OR.getProperty("searchWiki_XPATH"))).sendKeys(config.getProperty("searchMovie"));
		click("searchWikiBtn_XPATH");
		//driver.findElement(By.xpath(OR.getProperty("searchWikiBtn_XPATH"))).click();
		countryWiki=driver.findElement(By.xpath(OR.getProperty("countryWiki_XPATH"))).getText();
		System.out.println(countryWiki);
		releaseWiki=driver.findElement(By.xpath(OR.getProperty("releaseWiki_XPATH"))).getText();
		System.out.println(releaseWiki);

		//driver.switchTo().window(driver.getWindowHandle());
		driver.get(config.getProperty("website2"));
		//type("searchIMDB_XPATH", searchMovie_var);
		driver.findElement(By.xpath(OR.getProperty("searchIMDB_XPATH"))).sendKeys(config.getProperty("searchMovie"));
		//click("searchIMDBBtn_XPATH");
		driver.findElement(By.xpath(OR.getProperty("searchIMDBBtn_XPATH"))).click();
		WebElement ele=driver.findElement(By.partialLinkText("Pushpa: The Rise"));
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();

		countryIMDB=driver.findElement(By.xpath(OR.getProperty("countryIMDB_XPATH"))).getText();
		System.out.println(countryIMDB);
		releaseIMDB=driver.findElement(By.xpath(OR.getProperty("releaseIMDB_XPATH"))).getText();
		System.out.println(releaseIMDB);
		Thread.sleep(5000);


	}

		@Test
		public void compareCountry() throws InterruptedException{
				Assert.assertEquals(countryWiki, countryIMDB);
		}
		
		//type("searchWiki_XPATH", searchMovie_var);
		//click("searchWikiBtn_XPATH");
		
	}
