package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTripHobo {
	WebDriver driver;
	WebDriverWait wait;
	Actions builder;

	@Test
	public void tripHoboTest() throws InterruptedException {
		driver.get("https://www.triphobo.com/");
		driver.manage().window().maximize();
		//plan your next vacation
		wait.until(ExpectedConditions.elementToBeClickable(By.id("plan-my-trip"))).click();
		
		//Where do you want to go?
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class='form-control search']>input")))
				.click();
		driver.findElement(By.cssSelector("div[class='form-control search']>input")).sendKeys("hous");
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//span[text()='Houston, Texas, United States']")));
		WebElement city = driver.findElement(By.xpath("//span[text()='Houston, Texas, United States']"));
		builder.moveToElement(city).click().perform();
		
		//Selecting Start and End Date
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='start-date-control']"))).click();
		WebElement date = driver.findElement(By.xpath("//td[@data-month='9']/a[text()='25']"));
		builder.moveToElement(date).click().perform();
		driver.findElement(By.xpath("//td[@data-month='10']/a[text()='25']")).click();
		
		//start planning
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='button-box']/div/span"))).click();
		
		//About your Trip
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("[id='js_city_next_step_title']"))).click();
		
		//About you
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Skip to']"))).click();
		
		//Trip Overview	
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Trip Overview']")));
		driver.findElement(By.xpath("//div[text()='Trip Overview']")).click();
		Thread.sleep(15000);
		//Edit this plan
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Edit This Plan']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Edit This Plan']")));*/
		WebElement editPlan=driver.findElement(By.xpath("//span[text()='Edit This Plan']"));
		editPlan.click();
		Thread.sleep(8000);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/div[text()='Johnson Space Center']")));
		WebElement source = driver.findElement(By.xpath("//div[text()='Johnson Space Center']"));
		WebElement target= driver.findElement(By.xpath("//div[text()='Houston Astros']"));
		builder.dragAndDrop(source, target).perform();
		Thread.sleep(15000);

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
