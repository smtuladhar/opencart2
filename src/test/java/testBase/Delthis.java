package testBase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Delthis {

	
	@Test
	public void test() {
	WebDriver driver;
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver();
	driver.manage().window().fullscreen();
	driver.get("https://demo.opencart.com/index.php?route=account/register&language=en-gb");
	
	driver.findElement(By.id("input-firstname")).sendKeys("XXS");
	
	driver.findElement(By.name("agree")).click();
	Boolean status=driver.findElement(By.name("agree")).isSelected();
	System.out.println("Our program was selected "+status);
	driver.close();
	
	}
	
}
