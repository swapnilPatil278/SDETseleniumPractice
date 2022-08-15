package pageModel;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SwitchToFrame {

	WebDriver driver;
	
	public void handlingSingleFrame(WebDriver driver) {
		
		this.driver=driver;
		
		driver.get("https://demo.automationtesting.in/Frames.html");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[1]/a")).click();
		
//		String mainHandle=driver.getWindowHandle();
//		
//		Set <String> handles=driver.getWindowHandles();
//		for(String Id:handles) {
//			if(Id.equals(mainHandle)==false) {
//				driver.switchTo().frame(Id);
//				
//				driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("hii...am swapnil");
//				System.out.println(driver.getTitle());
//			}
//				
//		}
		driver.switchTo().frame("SingleFrame");
		System.out.println("number of frames "+driver.findElements(By.tagName("iframe")).size());
		System.out.println(driver.getTitle());
	//	System.out.println(handles);
	
	}
	
	public void handlingFrameInFrame(WebDriver driver) {
		
		this.driver=driver;
		
		driver.get("https://demo.automationtesting.in/Frames.html");	
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("/html/body/section/div[1]/div/div/div/div[1]/div/ul/li[2]/a")).click();
		driver.switchTo().frame(1);
		System.out.println(driver.getTitle());
		
//		String mainHandle=driver.getWindowHandle();
//		int i = 0;
//		Set <String> handles=driver.getWindowHandles();
//		for(String Id:handles) {
//			if(Id.equals(mainHandle)==false) {
//				driver.switchTo().frame(Id);
//				
//				//driver.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("hii...am swapnil");
//				System.out.println(driver.getTitle());
//				i=i+1;
//			}
//				
//		}
//		System.out.println("i= "+i);
	//	System.out.println("number of frames "+driver.findElements(By.tagName("iframe")).size());
	//	System.out.println(handles);
	}
	
}
