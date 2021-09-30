package week4.day1;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("http://leaftaps.com/opentaps/control/login");

		// Enter username password

		driver.findElement(By.name("USERNAME")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		// click on login using class locator
		driver.findElement(By.className("decorativeSubmit")).click();

		// Click on crm/sfa link

		driver.findElement(By.partialLinkText("CRM/SFA")).click();

		// Click on contacts button

		driver.findElement(By.linkText("Contacts")).click();

		// Click on merge contacts

		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();

		Thread.sleep(2000);

		// Click on widget of from contact
		driver.findElement(By.xpath("//img[@src='/images/fieldlookup.gif'][1]")).click();

		// move to next window
		Set<String> windowSet = driver.getWindowHandles();

		List<String> windowlist = new ArrayList<String>(windowSet);

		driver.switchTo().window(windowlist.get(1));

		// click on first contact from the table

		Thread.sleep(2000);

		driver.findElement(By.xpath("//td[contains(@class,'td-partyId x-grid3-cell-first')]/div/a")).click();

		driver.switchTo().window(windowlist.get(0));
		Thread.sleep(3000);
		String title2 = driver.getTitle();
		System.out.println("Tile is " + title2);

		// click on wedget to contact

		driver.findElement(By.xpath("(//img[@src='/images/fieldlookup.gif'])[2]")).click();

		// Create a set and list for new window

		Set<String> Winset2 = driver.getWindowHandles();

		List<String> winList2 = new ArrayList<String>(Winset2);

		driver.switchTo().window(winList2.get(1));
		Thread.sleep(2000);

		// click on second record from table

		driver.findElement(By.xpath("(//td[contains(@class,'td-partyId x-grid3-cell-first')])[2]/div/a")).click();
		
		driver.switchTo().window(winList2.get(0));

		driver.findElement(By.className("buttonDangerous")).click();

		// Accept the Alert

		Alert alert = driver.switchTo().alert();
		alert.accept();
		String title = driver.getTitle();

		if (title.contains("View Contact"))
			System.out.println("Contact succefully	merged");
		else
			System.out.println("Merging not done");

	}

}
