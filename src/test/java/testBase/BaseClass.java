package testBase;

import java.io.File;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Logger  logger;
	public ResourceBundle rb;
	@BeforeClass(groups= {"master","sanity","regression"})
	@Parameters({"browser"})
	public void setup(String br)
	
	{
		
		logger=LogManager.getLogger(this.getClass());
		rb=ResourceBundle.getBundle("config");
		if(br.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();	
			logger.info("Chrome browser initiated");
		}

		else if(br.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();	
			logger.info("Edge browser initiated");
		}

		else if(br.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();	
			logger.info("firefox browser initiated");
		}
		
		//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
	}

	
	@AfterClass(groups= {"master","sanity","regression"})
	public void tearDown() throws InterruptedException

	{
		Thread.sleep(3000);
		driver.close();
	}


	public String randomString() {


		String randomGeneratedString=RandomStringUtils.randomAlphabetic(5);
		return randomGeneratedString;
	}

	public int randomNumber() {
		String randomGeneratedNum=RandomStringUtils.randomNumeric(5);
		return(Integer.parseInt(randomGeneratedNum));
	} 
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "\\screenshots\\" + tname + ".png");
		FileUtils.copyFile(source, target);
	}
	
}
