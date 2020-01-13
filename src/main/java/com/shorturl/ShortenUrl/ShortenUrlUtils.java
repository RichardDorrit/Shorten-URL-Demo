package com.shorturl.ShortenUrl;

public class ShortenUrlUtils {

	static String charset="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	static int length=charset.length();
	public String generateShortURL(int id) {
		String code="";
		while(id>length-1) {
			code+=""+charset.charAt((int) (id%length));
			id=(int) Math.floor(id/length);
		}
		code+=charset.charAt(id);
		return code;
	}
	
}
