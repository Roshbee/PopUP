package testPopup;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.table.TableStringConverter;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import net.bytebuddy.asm.Advice.Argument;

public class Amazon {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:\\workspace\\Fitpeo\\driver1\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in");
		driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebElement element = driver.findElement(By.xpath("//*[@id=\"hmenu-content\"]/ul[1]/li[16]/a"));
		JavascriptExecutor hsExecutor = (JavascriptExecutor) driver;
		hsExecutor.executeScript("arguments[0].click();", element);
		driver.findElement(By.xpath("//*[text()='All Mobile Phones']")).click();
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("OnePlus 11 5G", Keys.ENTER);
		driver.findElement(By.xpath(
				"//*[@id=\"search\"]/div[1]/div[1]/div/span[1]/div[1]/div[3]/div/div/div/div/div/div[2]/div/div/div[1]/h2"))
				.click();
		String parentwindow = driver.getWindowHandle();
		Set<String> allwindowSet = driver.getWindowHandles();
		allwindowSet.remove(parentwindow);
		Iterator it = allwindowSet.iterator();
		String childwindowString = (String) it.next();
		driver.switchTo().window(childwindowString);
		WebElement totalSpecificationElement = driver
				.findElement(By.xpath("//ul[@class='a-unordered-list a-vertical a-spacing-mini']"));
		if (totalSpecificationElement.isDisplayed()) {
			System.out.println("All the specification present");
		}
	}

}
