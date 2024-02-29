
package com.Lumen.YourStore.utils;

import java.util.Date;

public class customUtils {
	
	public static final long wait_Time = 5;
	

	public static String generateEmailWithtimeStamp() {
		Date date= new Date();
		String timeStamp= date.toString().replace(" ", "_").replace(":", "_");
		return "sush"+timeStamp+"@gmail.com";
	}
	

	
	

}
