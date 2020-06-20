package com.ct.qa.constants;

/**
 * 
 * @author Vandana
 *
 */
public enum HomePageConstant {

	YOUR_TRIP("Your trips"),ONEWAY_SHEET_NAME("OneWay");
	
	
	 private String message;
	
	 HomePageConstant(String message) {
		this.message=message;
	}
	 
	public String getMessage() {
		 return message;
	}
}
