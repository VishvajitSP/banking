package scripts;


import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsAnnaUni {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@Test
	public void ActionsAnnaUniTest() throws InterruptedException {
		driver.get("https://www.annauniv.edu/department/index.php");
		driver.manage().window().maximize();
		
		
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div/a/strong[text()=' Faculty of Civil Engineering ']"))).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div//a[contains(text(),'DIVISION')]"))).click();
		WebElement division=driver.findElement(By.xpath("//div//a[contains(text(),'DIVISION')]"));
		WebElement ocean = driver.findElement(By.xpath("//li/a[text()='Institute for Ocean Management']"));
		builder.moveToElement(division).moveToElement(ocean).build().perform();
		String parentWindowHandle = driver.getWindowHandle();
		ocean.click();
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[@name='link2']"))).click();
		
		Set<String> allWindowHandles = driver.getWindowHandles();
		for(String oneWindow:allWindowHandles)
		{
			System.out.println(oneWindow);
			if(!oneWindow.equals(parentWindowHandle))
				try{
				driver.switchTo().window(oneWindow);
				
			}
			
			catch(NoSuchWindowException e)
			{
				Assert.fail("Ocean Management Window expected but not appeared...");
			}
		}
		String title = driver.getTitle();
		 String expectTitle = "Institute For Ocean Management - Anna University offers M.Tech in Coastal Management. ENVIS Center for Coastal Zone Management and Coastal Shelterbelts";
		 Assert.assertEquals(title, expectTitle);
		 System.out.println(title);
		 
		/*wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div/a[text()='Home']"))).click();
		Thread.sleep(2000);*/
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[text()='Research Themes']")));
		WebElement themes = driver.findElement(By.xpath("//div/a[text()='Research Themes']"));
		
		WebElement coastal =driver.findElement(By.xpath("//div[text()='Coastal Pollution Monitoring and Hazards ']"));
		builder.moveToElement(themes).click(coastal).build().perform();
		String expectedHazardTitle=":: IOM - Institute For Ocean Management -  Anna University ::";
		String actualHazardTitiel =driver.getTitle();
		Assert.assertEquals(expectedHazardTitle, actualHazardTitiel);
		Thread.sleep(3000);
	}
	
	@Test
	public void oceanManagement() throws InterruptedException{
		driver.get("https://www.annauniv.edu/iom/index.php");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/a[text()='Research Themes']")));
		WebElement themes = driver.findElement(By.xpath("//div/a[text()='Research Themes']"));
		
		WebElement coastal =driver.findElement(By.xpath("//div[text()='Coastal Pollution Monitoring and Hazards ']"));
		builder.moveToElement(themes).click(coastal).build().perform();
		Thread.sleep(3000);
		
	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver",
				"V:\\Vishvajit\\JavaPracticeNeon\\WebDriverTrainingInterview\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 10);
		builder = new Actions(driver);
	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}
}
