package com.practice.regex;

public class IPv6Check {
 
	private static final String IPv6REGEX_COMP_GROUP = "((([0-9a-fA-F]){1,4}):)";
	private static final String IPv6REGEX = "^("
			+ "("+IPv6REGEX_COMP_GROUP+"{7}([0-9a-fA-F]){1,4}"+")"
			+ "|("+IPv6REGEX_COMP_GROUP+"{5}([0-9a-fA-F]){1,4}"+")"		// how to bring two :00fh:: only
			+ ")$";
	
	public static void main(String[] args) {
		
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(IPv6REGEX);
		String ip;
		java.util.regex.Matcher m;
				
		//ip = "2001:0db8:85a3:0000:0000:8a2e:0370:7334";
		ip = "0dB8:0dB8:0dB8:0dB8:0dB8:0dB8:0dB8:0dB8";
		m = p.matcher(ip);
		assert m.find();
		
		ip = "1:0dB8:0dB8:A:B:0dB8:f:0dB8";
		m = p.matcher(ip);
		assert m.find();
		
		ip = "1:0dB8:A:B:f:0dB8";
		m = p.matcher(ip);
		assert m.find();
	}
}
