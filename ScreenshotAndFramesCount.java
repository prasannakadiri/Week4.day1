package week4.day1;

import java.time.Duration;
import java.util.List;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.utils.FileUtil;

import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotAndFramesCount {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver objDriver = new ChromeDriver();
		objDriver.manage().window().maximize();
		objDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		objDriver.get("http://leafground.com/pages/frame.html");

		Thread.sleep(2000);

		WebElement frame1 = objDriver.findElement(By.xpath("//div[@id='wrapframe']/iframe[1]"));
		objDriver.switchTo().frame(frame1);
		WebElement clickMeBtn = objDriver.findElement(By.id("Click"));

		File src1 = clickMeBtn.getScreenshotAs(OutputType.FILE);
		File dst1 = new File("./snaps/button.png");
		FileUtils.copyFile(src1, dst1);

		
		//swtichTo the parent frame
		objDriver.switchTo().defaultContent();
		List<WebElement> frames=objDriver.findElements(By.tagName("iframe"));
		
		System.out.println("Number of frames"+frames.size());
		
	}

}
