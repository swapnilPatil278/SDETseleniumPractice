package pageModel;

import java.awt.AWTException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.sikuli.script.FindFailed;



public class RegistrationPage {

	WebDriver driver;

	By firstName = By.xpath("//*[@id=\"basicBootstrapForm\"]/div[1]/div[1]/input");
	By lastName = By.xpath("//input[@placeholder='Last Name']");
	By address = By.xpath("//textarea[@rows='3']");
	By email = By.xpath("//input[@type='email']");
	By phone = By.xpath("//input[@type='tel']");
	By gender = By.xpath("//input[@value='Male']");
	By hobbies1 = By.xpath("//input[@id='checkbox1']");
	By hobbies2 = By.xpath("//input[@id='checkbox2']");
	By languages = By.xpath("//div[@id='msdd']");
	By skills = By.xpath("//select[@id='Skills']");
	By country = By.xpath("//span[@role='combobox']");
	By year = By.xpath("//select[@id='yearbox']");
	By month = By.xpath("//select[@ng-model='monthbox']");
	By day = By.xpath("//select[@ng-model='daybox']");
	By password = By.xpath("//input[@id='firstpassword']");
	By confirmpassword = By.xpath("//input[@id='secondpassword']");
	By submitButton=By.xpath("//button[@id='submitbtn']");

	
	public void getFirstName(String fName,WebDriver driver) {
		this.driver=driver;
		driver.findElement(firstName).sendKeys(fName);
	}

	public void getLastName(String lName,WebDriver driver) {
		this.driver=driver;
		driver.findElement(lastName).sendKeys(lName);
	}

	public void getAddress(String Address,WebDriver driver) {
		this.driver=driver;
		driver.findElement(address).sendKeys(Address);
	}
	
	public void uploadPhoto(WebDriver driver) throws AWTException, FindFailed {
		
		this.driver=driver;
		driver.findElement(By.xpath("//*[@id=\"imagesrc\"]")).sendKeys("F:\\New folder\\NEWSwapnil Photo.jpg");
		//using Sikuli
//		Pattern filePathBox=new Pattern("C:\\Users\\SWAPNIL\\Desktop\\filePath.PNG");
//		Pattern OpenButton=new Pattern("C:\\Users\\SWAPNIL\\Desktop\\openButton.PNG");
//		
//		Screen screen=new Screen();
//		
//		screen.wait(filePathBox, 20);
//		screen.type(filePathBox,"F:\\New folder\\Swapnil Photo.jpg");
//		screen.click(OpenButton);
	}

	public void getEmail(String Email,WebDriver driver) {
		this.driver=driver;
		driver.findElement(email).sendKeys(Email);
	}

	public void getPhone(String Phone,WebDriver driver) {
		this.driver=driver;
		driver.findElement(phone).sendKeys(Phone);
	}

	public void getGender(WebDriver driver) {
		this.driver=driver;
		driver.findElement(gender).click();
	}

	public void getHobbies1(WebDriver driver) {
		this.driver=driver;
		if (driver.findElement(hobbies1).isSelected() == false) {
			driver.findElement(hobbies1).click();
		}
	}

	public void getHobbies2(WebDriver driver) {
		this.driver=driver;
		if (driver.findElement(hobbies2).isSelected() == false) {
			driver.findElement(hobbies2).click();
		}
	}

	public void getLanguages(WebDriver driver) {
		this.driver=driver;
		WebElement Language = driver.findElement(languages);
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)",Language);
		
		Language.click();
		driver.findElement(By.linkText("English")).click();
		
		Language.click();
		driver.findElement(By.linkText("Hindi")).click();
	
		//Select command works only when WebElement have the "select" Tag
		
	}

	public void getSkills(WebDriver driver) {
		this.driver=driver;
		WebElement Skills = driver.findElement(skills);
		
//		JavascriptExecutor js=(JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true)",Skills);
		
		Select select = new Select(Skills);
		select.selectByValue("Java");

	}

	public void getCountry(WebDriver driver) {
		
		this.driver=driver;
		driver.findElement(country).click();

		//driver.findElement(By.xpath("//input[@role='textbox']")).sendKeys("India");
		//driver.findElement(By.xpath("//li[@role='treeitem']")).click();
		
		//or
		
		driver.findElement(By.xpath("//*[@id=\"select2-country-results\"]/li[6]")).click();
	}

	public void getDateOfBirth(WebDriver driver) {
		this.driver=driver;
		//Year
		WebElement Year = driver.findElement(year);
		//Year.click();
		Select select = new Select(Year);
		select.selectByValue("1994");
	
		//Month
		WebElement Month = driver.findElement(month);
		//Month.click();
		//driver.findElement(By.linkText("1994")).click();
		select = new Select(Month);
		select.selectByValue("August");
		
		//Day
		WebElement Day = driver.findElement(day);
	//	Day.click();
		select = new Select(Day);
		select.selectByValue("27");
	}

	public void getPassword(WebDriver driver) {

		this.driver=driver;
		driver.findElement(password).sendKeys("123abc");
	}

	public void getConfirmpassword(WebDriver driver) {
		this.driver=driver;
		driver.findElement(confirmpassword).sendKeys("123abc");
	}

	public void getSubmitButton(WebDriver driver) {
		this.driver=driver;
		driver.findElement(submitButton).click();
	}
}
