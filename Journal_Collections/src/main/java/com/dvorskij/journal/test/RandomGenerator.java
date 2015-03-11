package com.dvorskij.journal.test;

import java.util.Date;
import java.util.Random;

public class RandomGenerator {
	private static Random random = new Random();
	
	private static int startUp   = (int) 'A';
	private static int finishUp  = (int) 'Z';
	private static int startLow  = (int) 'a';
	private static int finishLow = (int) 'z';
	
	public static String getRandomString(int size){
		return null;
	}
	
	public static Date  getRandomDate(){
		return null;
	}
	
	public static char getRandomChar(){
		// choice if upper 0 or lower case 1
		int choice = random.nextInt(2);
		
		return 0;
	}

}
