package pageModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Utilities {
	static WebDriver driver;
	public static WebDriver getWebDriver() {
		
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		return driver;
	}

}
