package com.practice.regex;

public class IPv4Check {
 
	private static final String IPv4REGEX = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9][0-9]|[0-9]|0[0-9][0-9])\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[0-9][0-9]|[0-9]|0[0-9][0-9])$";
	private static final String IPv4REGEX_WITHOUT_LEADING_ZERO = "^((25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9]|10)\\.){3}(25[0-5]|2[0-4][0-9]|1[0-9][0-9]|[1-9][0-9]|[0-9]|10)$";
	//private static final String IPv4REGEX = "^(([0-9]|[0-9][0-9]|[0,1][0-9][0-9]|[0,1,2][0-5][0-5])\\.){3}([0-9]|[0-9][0-9]|[0,1][0-9][0-9]|[0,1,2][0-5][0-5])$";
	
	public static void main(String[] args) {
		
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(IPv4REGEX);
		String ip;
		java.util.regex.Matcher m;
				
		//ip = "099.255.010.000";
		ip = "19.19.19.199";
		m = p.matcher(ip);
		assert m.find();

		ip = "1.1.1.1";
		m = p.matcher(ip);
		assert m.find();

		ip = "23.45.22.32";
		m = p.matcher(ip);
		assert m.find();
		
		ip = "023.045.022.032";
		m = p.matcher(ip);
		assert m.find();
		
		ip = "023.045.022.000";
		m = p.matcher(ip);
		assert m.find();
		
		ip = "255.255.255.255";
		m = p.matcher(ip);
		assert m.find();
	}
}
