package com.dvorskij.journal.test;

import java.util.Date;
import java.util.Random;

public class RandomGenerator {
	private static Random random = new Random();
	
	private static int startUp   = (int) 'A';
	private static int finishUp  = (int) 'Z';
	private static int startLow  = (int) 'a';
	private static int finishLow = (int) 'z';
	
	public String getRandomString(int size){
		return null;
	}
	
	public Date  getRandomDate(){
		return null;
	}
	
	public char getRandomChar(){
		random.nextInt(1);
		return 0;
	}

}
