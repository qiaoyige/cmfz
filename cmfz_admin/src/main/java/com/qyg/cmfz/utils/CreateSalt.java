package com.qyg.cmfz.utils;

import java.util.Random;

/**
 * @Description 生成私盐
 * @Author gege
 * @Time 2018/7/4  16:36
 */
public class CreateSalt {

	public static  String  getSalt(){
		String str="1234567890abcdefghijklmnopqrstuvwxyz";
		char[] chs=str.toCharArray();
		
		char[] ch=new char[6];
		
		Random random=new Random();
		StringBuilder builder=new StringBuilder();
		for (int i = 0; i < ch.length; i++) {
			char c=chs[random.nextInt(chs.length)];
			builder.append(c);
		}
		
		return builder.toString();
		
	}
}
