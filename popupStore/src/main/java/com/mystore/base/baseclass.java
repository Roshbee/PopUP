package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class baseclass {
	public static Properties prop;
	public static WebDriver driver;
	public void loadConfig() {
try {
	 prop=new Properties();
	System.out.println("Super constructor invoked");
	FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\Configuration\\config.properties");
	prop.load(fis);
	System.out.println("driver "+driver);
} catch (FileNotFoundException e) {
	e.printStackTrace();
}catch (IOException e) {
	e.printStackTrace();
}
	}

public void launchapp() {
	WebDriverManager.chromedriver().setup();
	String browserName=prop.getProperty("browser");
	if(browserName.contains("Chrome")) {
		driver=new ChromeDriver();
	}else if(browserName.contains("FireFox")) {
		driver=new FirefoxDriver();
	}else if(browserName.contains("IE")) {
		driver=new InternetExplorerDriver();
	}

	driver.get(prop.getProperty("url"));
	
	
	
	
	
}



}
