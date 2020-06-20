package com.ct.qa.constants;

/**
 * 
 * @author Vandana
 *
 */
public enum LoginConstant {

	LOGIN_TITLE("Sign in to Cleartrip"),LOGIN_SHEET_NAME("Login");
	
	
	 private String message;
	
	 LoginConstant(String message) {
		this.message=message;
	}
	 
	public String getMessage() {
		 return message;
	}
}
