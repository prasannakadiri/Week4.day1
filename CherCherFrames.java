package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCherFrames {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		ChromeDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");

		// Entering into the frame1

		driver.switchTo().frame("frame1");

		// Locating the Element in frame1
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Prasanna");

		// switch to frame 3
		
		driver.switchTo().frame("frame3");
		driver.findElement(By.id("a")).click();
		
		//Come out of the current frmae
		
		driver.switchTo().defaultContent();
		
		// Entering into Frame2
		
		driver.switchTo().frame("frame2");
		
		WebElement dbox1=driver.findElement(By.id("animals"));
		
		Select dpoptions=new Select(dbox1);
		
		dpoptions.selectByIndex(2);
		
		driver.switchTo().defaultContent();		
	
	}
	

}
