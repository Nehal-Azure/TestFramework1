package com.gwit.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter {
	
	public static ExtentReports generateExtentReport() {
		//Initilizing extent reports
		ExtentReports extentReport = new ExtentReports(); 
		
		//Defining Report html path
		File extentReportFile = new File(System.getProperty("user.dir")+"\\test-output\\ExtentReports\\extentReport.html");
		ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportFile);
		
		//setting some report config
		
		sparkReporter.config().setTheme(Theme.DARK);
		sparkReporter.config().setReportName("Test Automation Results");
		sparkReporter.config().setDocumentTitle("Test Automation Report");
		sparkReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
		
		//Attaching report
		extentReport.attachReporter(sparkReporter);
	//Setting some general config for the report		
		//Getting url from properties file
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"/src/test/resources/config.properties");
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		extentReport.setSystemInfo("Application URL", prop.getProperty("url"));
		extentReport.setSystemInfo("Browser Name", prop.getProperty("browser"));
		extentReport.setSystemInfo("Operating System Name", System.getProperty("os.name"));
		extentReport.setSystemInfo("System User Name", System.getProperty("user.name"));
		extentReport.setSystemInfo("Java Version", System.getProperty("java.version"));
		
		return extentReport;
		
		
		
		
		
	}

}
