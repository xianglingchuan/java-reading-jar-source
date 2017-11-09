package com.javax.servlet;

import javax.swing.text.StyledEditorKit.BoldAction;

public class TestDemo {
	
	private static final String tspecials = ",; ";
	 
	private boolean isToken(String value) {
		int len = value.length();
		for (int i = 0; i < len; i++) {
			//获取每个字符
		    char c = value.charAt(i);
	        //0x20表示十进制32
		    //0x7f表示十进制91
		    System.out.println("c:"+c);
		    int value2 = Integer.valueOf(c);
		    System.out.println("value2:"+value2);
		    //如果是(space)标号  或者(delete)标号 或者发现在过滤的标号之内的编码。返回false
		    if (c < 0x20 || c >= 0x7f || tspecials.indexOf(c) != -1)
			return false;
		}
		return true;
    }	
	
	public static void main(String[] args) {
		//TestDemo demo = new TestDemo();
		//boolean result = demo.isToken("你好");
		//System.out.println(result);
		
		TestDemo.SystemArraycopyByTest();
		
	}
	
	
	
	public static void SystemArraycopyByTest(){
		
		int[] fun ={0,1,2,3,4,5,6}; 
		int[] fun2 = {7,8,9};
		
		int[] allfun = new int[fun.length+fun2.length];
		System.arraycopy(fun, 0, allfun, 0, fun.length);
		System.arraycopy(fun2, 0, allfun, fun.length, fun2.length);
		
		
		for (int i : allfun) {
			System.out.print(i+",");
		}
		
		System.out.println(allfun.toString());
		
	}
	

}
