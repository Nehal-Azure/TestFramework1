package com.gwit.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.gwit.utils.Utilities;

public class BaseTest {
	
	WebDriver driver ;
	public Properties prop;
	public Properties dataProp;
	
	public BaseTest()  {
		prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		dataProp = new Properties();
		File datafile = new File(System.getProperty("user.dir")+"/src/test/resources/testdata.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop.load(fis);
			}catch(Throwable e) {
				e.printStackTrace();
			}
		try {
		FileInputStream fis2 = new FileInputStream(datafile);
		dataProp.load(fis2);
		}catch(Throwable e) {
			e.printStackTrace();
		}
	}
	
	public WebDriver initializeBrowserAndOpenApplicationUrl(String browserName) {
		
		if(browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}
		else if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}
		
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPICIT_WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGELOAD_TIME));
		driver.get(prop.getProperty("url"));
		
		return driver;
	}

}
