package com.GetMethodsRestAssured.qa.TestBase;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {

	public Properties prop;
	
	public TestBase()
	{
		prop=new Properties();
		try {
			FileInputStream ip=new FileInputStream("/Users/arka/Documents/workspace/GetMethodRestAssuredFirstAssignment/src/main/java/com/GetMethodsRestAssured/qa/config/config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
