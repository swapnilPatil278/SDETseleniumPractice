package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchToAlertPage {

	WebDriver driver;

	public void getAlertWithOkButton(WebDriver driver) {

		this.driver=driver;
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"OKTab\"]/button")).click();
		
	}
	
	public void getAlertWithOkAndCancelButton(WebDriver driver) {
		
		this.driver=driver;
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"CancelTab\"]/button")).click();
		
	}

	public void getAlertWithTextBox(WebDriver driver) {
		
		this.driver=driver;
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Textbox\"]/button")).click();
		
	}
	
	
}
