package testPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseUtil.BaseClass;

public class HomePageTest extends BaseClass{
	JavascriptExecutor js;
	Dimension dimension;
	Actions actions;
	Select select;
	
	@Test (enabled = false)
	public void clickSelenium () throws InterruptedException {
		Thread.sleep(3000);
		dimension = new Dimension(800, 500);
		driver.manage().window().setSize(dimension);
		System.out.println("Window set size is: "+driver.manage().window().getSize());
		WebElement selenium = driver.findElement(By.xpath("//a[text()='Selenium']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", selenium);
		Thread.sleep(3000);
	}
	
	@Test (enabled = false)
	public void use_of_assert_method () {
		WebElement logo = driver.findElement(By.xpath("//img[@src='/static/img/logo/With-text.png' and @alt='Enthrall IT']"));
		logo.isDisplayed();
		//Assert.assertTrue(true, "logo is not present in the Enthrall it website.");
		Assert.assertFalse(false, "Logo is displayed in the Enthrall It website.");
		
	}
	
	@Test (enabled = false)
	public void use_of_assertEquals_method () {
		String expected = "Enthrall IT";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, "HomePage tile doesnt match");
	}
	
	@Test (enabled = false)
	public void use_of_softAssertion_method () {
		String expected = "Enthrall IT";
		String actual = driver.getTitle();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected, "HomePage tile doesnt match");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: "+currentUrl);
	}
	
	// Hover Action 0r Mouse Hover Over Action
	@Test (enabled = false)
	public void use_of_actions () throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		actions = new Actions(driver);
		WebElement prime = driver.findElement(By.xpath("//span[text()='Prime']"));
		actions.moveToElement(prime).build().perform();
		Thread.sleep(3000);
		
	}
	
	// for drop down or all categories
	// here using selectByIndex() method
	@Test (enabled = true)
	public void use_of_selectByIndex_forDropdown () throws InterruptedException {
		WebElement selenium = driver.findElement(By.xpath("//a[text()='Selenium']"));
		js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", selenium);
		Thread.sleep(3000);
		WebElement dropDown = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
		js.executeScript("arguments[0].scrollIntoView();", dropDown);
		Thread.sleep(3000);
		select = new Select(dropDown);
		select.selectByVisibleText("Unemployed");
		Thread.sleep(3000);
		
		
	}

}




























