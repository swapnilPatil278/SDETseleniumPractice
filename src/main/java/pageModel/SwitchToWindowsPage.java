package pageModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchToWindowsPage {

	WebDriver driver;

	public void getOPenNewTabbedWindows(WebDriver driver) {
		
		this.driver=driver;
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div")).click();
		driver.findElement(By.xpath("//*[@id=\"Tabbed\"]/a/button")).click();
		
	}

	public void getNewSeperateWindows(WebDriver driver) {

		this.driver=driver;
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[2]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Seperate\"]/button")).click();
		
	}

	public void getOPenMultipleSeperateWindows(WebDriver driver) {
		
		this.driver=driver;
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div[1]/ul/li[3]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"Multiple\"]/button")).click();
	}

}
