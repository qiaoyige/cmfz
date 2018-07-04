package com.qyg.cmfz.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description MD5加密
 * @Author gege
 * @Time 2018/7/4  16:36
 */
public class MD5 {

	public static String encryption(String str) {
		try {
			MessageDigest message=MessageDigest.getInstance("MD5");
			byte[] code=message.digest(str.getBytes());
			
			StringBuilder builder=new StringBuilder();
			
			for (byte b : code) {
				int c=b & 0xFF;
				
				if(c<16){
					builder.append("0");
				}
				builder.append(Integer.toHexString(c));
			}
			return builder.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
