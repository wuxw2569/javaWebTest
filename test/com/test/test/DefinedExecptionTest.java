package com.test.test;

import com.test.exception.DefinedException;

public class DefinedExecptionTest {
	public static void main(String[] args) {
		test2();
	}
	
	public static void test1() throws DefinedException{
		System.out.println("执行test1....");
		throw new DefinedException("test1方法执行抛出异常...");
	}
	public static void test2(){
		try {
			test1();
		} catch (DefinedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
			RuntimeException newExc = new RuntimeException("这里可抛出执行时异常...~~");
			newExc.initCause(e);
			throw newExc;
			
		}
	}
}
