package com.dvorskij.journal.test;

import java.text.ParseException;
import java.util.Date;
import java.util.Random;

import com.dvorskij.journal.pojo.Record;

public class Te {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// String s =
		// "2015-03-11 18:16:54 !!!   ExceptionRdvd Message fwf wrtg wg wetgwtw wrthw rthw rh";
		// System.out.println(s);
		// try {
		// System.out.println(new Record(s));
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }catch (NullPointerException e){
		// e.printStackTrace();
		// }
//		for (int i = 0; i < 10; i++)
//			System.out.println((new Random()).nextInt(2));
//		System.out.println("FINISH");
		
//		Date d = new Date();
//		
//		java.sql.Date f =  new java.sql.Date(d.getTime());
//		System.out.println(f.getSeconds());
		
		String patternPageN = "[0123456789]*";
		System.out.println("97778979966868".matches(patternPageN));
		

	}

}
