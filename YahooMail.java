package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class YahooMail {
	
	WebDriver driver;

  @Test
  public void yahooMail() throws InterruptedException {
	  
	  driver.get("https://login.yahoo.com/");
	  driver.manage().window().maximize();
	  Thread.sleep(3000);
	  driver.findElement(By.id("login-username")).sendKeys("phutane.vishvajit");
	  driver.manage().window().maximize();
	  driver.findElement(By.id("login-signin")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("login-passwd")).sendKeys("Jeet@1994");
	  Thread.sleep(3000);
	  driver.findElement(By.id("login-signin")).click();
	  Thread.sleep(3000);
	  //driver.findElement(By.xpath("//div/a[@role='button']"));
	  //Thread.sleep(3000);
	  String expectedTitle="Yahoo Search - Web Search";
	  String actualTitle =driver.getTitle();
	  Assert.assertEquals(actualTitle, expectedTitle);
	  
	  //driver.findElement(By.id("message-to-field")).sendKeys("");
	  
	  

  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "V:\\Vishvajit\\JavaPracticeNeon\\WebDriverTrainingInterview\\test\\resources\\chromedriver.exe");
	  driver=new ChromeDriver();
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
