package testPages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import baseUtil.BaseClass;
import static common.CommonActions.*;

public class HomePageTest extends BaseClass {

	@Test(enabled = false)
	public void clickSelenium() throws InterruptedException {
		Thread.sleep(3000);
		dimension = new Dimension(800, 500);
		driver.manage().window().setSize(dimension);
		System.out.println("Window set size is: " + driver.manage().window().getSize());
		WebElement selenium = driver.findElement(By.xpath("//a[text()='Selenium']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", selenium);
		Thread.sleep(3000);
	}

	@Test(enabled = false)
	public void use_of_assert_method() {
		WebElement logo = driver
				.findElement(By.xpath("//img[@src='/static/img/logo/With-text.png' and @alt='Enthrall IT']"));
		logo.isDisplayed();
		// Assert.assertTrue(true, "logo is not present in the Enthrall it website.");
		Assert.assertFalse(false, "Logo is displayed in the Enthrall It website.");

	}

	@Test(enabled = false)
	public void use_of_assertEquals_method() {
		String expected = "Enthrall IT";
		String actual = driver.getTitle();
		Assert.assertEquals(actual, expected, "HomePage tile doesnt match");
	}

	@Test(enabled = false)
	public void use_of_softAssertion_method() {
		String expected = "Enthrall IT";
		String actual = driver.getTitle();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actual, expected, "HomePage tile doesnt match");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Current URL is: " + currentUrl);
	}

	// Hover Action 0r Mouse Hover Over Action
	@Test(enabled = false)
	public void use_of_actions() throws InterruptedException {
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
	@Test(enabled = false)
	public void use_of_selectByIndex_forDropdown() throws InterruptedException {
		WebElement selenium = driver.findElement(By.xpath("//a[text()='Selenium']"));
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", selenium);
		Thread.sleep(3000);
		WebElement dropDown = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
		js.executeScript("arguments[0].scrollIntoView();", dropDown);
		Thread.sleep(3000);
		select = new Select(dropDown);
		select.selectByVisibleText("Unemployed");
		Thread.sleep(3000);
	}

	@Test(enabled = false)
	public void use_of_logger() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://www.amazon.com/");
		WebElement aboutUs = driver.findElement(By.xpath("(//a[text()='Best Sellers'])[1]"));
		clickElement(aboutUs);
		Thread.sleep(3000);
	}

	@Test(enabled = false)
	public void sendKeys_by_javaScript() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement searchField = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		WebElement clickButton = driver.findElement(By.id("nav-search-submit-button"));
		js.executeScript("arguments[0].value='Laptop'", searchField);
		js.executeScript("arguments[0].click()", clickButton);
		Thread.sleep(3000);

	}

	@Test(enabled = false)
	public void hiddenElement_by_selenium() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("hide-textbox")).click();
		driver.findElement(By.xpath("//input[@id='displayed-text']")).sendKeys("hello");
	}

	@Test(enabled = false)
	public void hiddenElement_by_javaScript() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://courses.letskodeit.com/practice");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.id("hide-textbox")).click();
		Thread.sleep(3000);
		WebElement field = driver.findElement(By.xpath("//input[@id='displayed-text']"));
		js.executeScript("arguments[0].value='hello'", field);
		Thread.sleep(3000);
		String s = (String) js.executeScript("return document.getElementById('displayed-text').value");
		System.out.println("Value of Hidden Field: " + s + "\n");

		// getting title of page using javaScript exucutor
		String title = (String) js.executeScript("return document.title");
		System.out.println("Tile of the page is: " + title);
	}

	// explicitly wait
	// 1. using visibilityOfElementLocated() method condition
	@Test(enabled = false)
	public void explicitlyWait01() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//a[normalize-space(text())='Request an Appointment' and @class='hidden-xs dropdown']")))
				.click();

	}

	// 2. using elementToBeClickable
	@Test(enabled = false)
	public void explicitlyWait02() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//a[normalize-space(text())='Request an Appointment' and @class='hidden-xs dropdown']")))
				.click();

	}

	// 3. using visibilityOf()
	@Test(enabled = false)
	public void explicitlyWait03() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement requestAppointment = driver.findElement(
				By.xpath("//a[normalize-space(text())='Request an Appointment' and @class='hidden-xs dropdown']"));
		wait.until(ExpectedConditions.visibilityOf(requestAppointment)).click();

	}

	// 4. using presenceOfElementLocated()
	@Test(enabled = false)
	public void explicitlyWait04() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		wait.until(ExpectedConditions.presenceOfElementLocated(
				By.xpath("//a[normalize-space(text())='Request an Appointment' and @class='hidden-xs dropdown']")))
				.click();

	}

	// 5. using textToBePresentInElement()
	@Test(enabled = false)
	public void explicitlyWait05() throws InterruptedException {
		Thread.sleep(3000);
		driver.get("https://www.mountsinai.org/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		WebElement requestAppointment = driver.findElement(By.xpath("//a[normalize-space(text())='Request an Appointment' and @class='hidden-xs dropdown']"));
		wait.until(ExpectedConditions.textToBePresentInElement(requestAppointment, "Request an Appointment"));

	}
	
	@Test (enabled = false)
	public void scrollDown_actionsClass () throws InterruptedException {
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
		Thread.sleep(3000);
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		Thread.sleep(3000);
	}
	
	@Test (enabled = true)
	public void scrollDown_by_javaScript () throws InterruptedException {
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,3000)", " ");
		Thread.sleep(3000);
		js.executeScript("window.scrollBy(0,-3000)", " ");
		Thread.sleep(3000);
		js.executeScript("history.go(0)", " "); // to refresh page
		Thread.sleep(3000);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
