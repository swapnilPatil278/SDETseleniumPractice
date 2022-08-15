package pageModelTesting;

import java.awt.AWTException;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.sikuli.script.FindFailed;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageModel.RegistrationPage;
import pageModel.SwitchToAlertPage;
import pageModel.SwitchToFrame;
import pageModel.SwitchToWindowsPage;
import pageModel.Utilities;

public class PageTesting {
	WebDriver driver;

	@BeforeMethod
	public void webDriver() {
		this.driver=Utilities.getWebDriver();
	}
	@Test
	public void verifyRegistration() throws FindFailed, AWTException, InterruptedException {
		RegistrationPage r1 = new RegistrationPage();

		driver.get("https://demo.automationtesting.in/Register.html");
		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		r1.getFirstName("Swapnil",driver);
		r1.getLastName("Patil",driver);

		r1.getAddress("At post Nimb Tal-Amalner, Dist-Jalgaon",driver);
		r1.getEmail("abc@gmail.com",driver);

		r1.uploadPhoto(driver);

		r1.getPhone("8868695986",driver);
		r1.getGender(driver);

		r1.getHobbies1(driver);
		r1.getHobbies2(driver);

		r1.getLanguages(driver);
		r1.getSkills(driver);

		r1.getCountry(driver);
		r1.getDateOfBirth(driver);

		r1.getPassword(driver);
		r1.getConfirmpassword(driver);

		r1.getSubmitButton(driver);

		Thread.sleep(3000);
		driver.close();
	}

	@Test
	public void verifySwitchToAlert() throws InterruptedException {

		SwitchToAlertPage switchPage = new SwitchToAlertPage();

		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Due to site has given different advertisement after clicking on Alert.
		// So we are directly providing Alert URL to driver.

//		Actions action=new Actions(driver);
//		
//		WebElement swto= driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/a"));
//		WebElement alrt= driver.findElement(By.xpath("//*[@id=\"header\"]/nav/div/div[2]/ul/li[4]/ul/li[1]/a"));
//		
//		action.moveToElement(swto).moveToElement(alrt).click().build().perform();
//		
//		driver.findElement(By.xpath("//*[@id=\"dismiss-button\"]")).click();

		// 1) Alert With Ok Button

		switchPage.getAlertWithOkButton(driver);
		driver.switchTo().alert().accept();

		Thread.sleep(2000);
		// 2) Alert With Ok and Cancel Button.
		switchPage.getAlertWithOkAndCancelButton(driver);
		// driver.switchTo().alert().accept(); //Click on Ok Button
		// OR
		driver.switchTo().alert().dismiss(); // Click on Cancel Button

		Thread.sleep(2000);
		// 3) Alert With TextBox
		switchPage.getAlertWithTextBox(driver);
		driver.switchTo().alert().sendKeys("Peter The Family Guy");
		driver.switchTo().alert().accept();

		Thread.sleep(2000);
		driver.close();

	}

	@Test
	public void verifySwitchToWindow() throws InterruptedException {

		SwitchToWindowsPage stw = new SwitchToWindowsPage();

		driver.get("https://demo.automationtesting.in/Windows.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// 1) Handling New Tabbed Window
		
		String StartingWHandle=driver.getWindowHandle();
		stw.getOPenNewTabbedWindows(driver);
		
		Set<String> handle = driver.getWindowHandles();
		System.out.println("while Executing Single Tab window command");
		for(String url:handle) {
			if(StartingWHandle.equals(url)==false) {
				String Title=driver.switchTo().window(url).getTitle();
				System.out.println("Title of the page is "+Title);
				driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
			}
		}
		
		Thread.sleep(2000);
		
		driver.close();
		driver.switchTo().window(StartingWHandle);
		
		// 2)Handling new seperate Window.
		
		stw.getNewSeperateWindows(driver);
		
		handle = driver.getWindowHandles();
		System.out.println("while Executing Seperate window command");
		for(String url:handle) {
			if(StartingWHandle.equals(url)==false) {
				String Title=driver.switchTo().window(url).getTitle();
				System.out.println("Title of the page is "+Title);
				driver.findElement(By.xpath("//*[@id=\"navbarDropdown\"]")).click();
			}
		}
		Thread.sleep(2000);
		
		driver.close();
		driver.switchTo().window(StartingWHandle);
		
		// 3)Handling multiple Windows.
		
		stw.getOPenMultipleSeperateWindows(driver);
		
		handle = driver.getWindowHandles();
		System.out.println("while Executing Multiple windows command");
		for(String url:handle) {
			if(StartingWHandle.equals(url)==false) {
				String Title=driver.switchTo().window(url).getTitle();
				System.out.println("Title of the page is "+Title);
			}
		}
		Thread.sleep(2000);
		driver.quit();
	}
	
	@Test
	public void verifySwitchToFrame() {
		
		SwitchToFrame stf=new SwitchToFrame();
		
		//stf.handlingSingleFrame(driver);
		
		stf.handlingFrameInFrame(driver);
		
		
		
		
		
	}
}
