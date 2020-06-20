package com.ct.qa.properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;

public class AppProperties {

	private static Properties property;
	
	private static AppProperties appProperties;
	
	private AppProperties() throws URISyntaxException, IOException{
				property = new Properties();
				URL resource=getClass().getClassLoader().getResource("config.properties");
				File file = new File(resource.toURI());
				FileInputStream ip = new FileInputStream(file);
				property.load(ip);
	}
	
	public static Properties getPropertyObject() {
		if(null==appProperties) {
			try {
				appProperties=new AppProperties();
			} catch (URISyntaxException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
		}
		return property;

	}
	
	
	
}
