package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;

public class DemoQa {
	WebDriver driver;
  @Test
  public void demoQa() throws InterruptedException {
	  driver.get("https://demoqa.com/automation-practice-form");
	  driver.manage().window().maximize();
	  WebElement name=driver.findElement(By.id("firstName"));
	  name.sendKeys("Vishvajit");
	  Thread.sleep(1000);
	  WebElement lastName=driver.findElement(By.id("lastName"));
	  lastName.sendKeys("Phutane");
	  Thread.sleep(3000);
	  WebElement gender = driver.findElement(By.xpath("//label[text()='Male']"));
	  Thread.sleep(1000);
	  gender.click();
	  Thread.sleep(1000);
	  WebElement hobby1 = driver.findElement(By.xpath("//label[text()='Sports']"));
	  if(!hobby1.isSelected())
	  hobby1.click();
	  Thread.sleep(1000);
	  WebElement hobby2 = driver.findElement(By.xpath("//label[text()='Reading']"));
	  if(!hobby2.isSelected())
	  hobby2.click();
	  Thread.sleep(1000);
	  WebElement hobby3 = driver.findElement(By.xpath("//label[text()='Music']"));
	  if(!hobby3.isSelected())
	  hobby3.click();
	  Thread.sleep(1000);
	  driver.findElement(By.id("submit"));
	  
	  System.out.println("Firstname:"+name.getAttribute("value"));
	  System.out.println("LastName:"+lastName.getAttribute("value"));
	  System.out.println("Gender:"+gender.getText());
	  System.out.print("Hobbies:"+hobby1.getText());
	  System.out.print(", "+hobby2.getText());
	  System.out.println(", "+hobby3.getText());
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.setProperty("webdriver.chrome.driver", "V:\\Vishvajit\\JavaPracticeNeon\\WebDriverTrainingInterview\\test\\resources\\chromedriver.exe");
	  driver=new ChromeDriver();
	 System.out.println("Inside before method after commit");
	
  }

  @AfterMethod
  public void afterMethod() {
	  driver.close();
  }

}
