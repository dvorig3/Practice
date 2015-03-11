package com.dvorskij.journal.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import com.dvorskij.journal.pojo.Importance;

public class ServiceTest {
	private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			DATE_PATTERN);

	public static void main(String[] args) {

		// String s = "gff/n";
		// System.out.println(s.matches(".* .*"));
		String s = "2015-03-11 18:16:54 !!!   ExceptionRdvd Message fwf wrtg wg wetgwtw wrthw rthw rh";

		final String separator = " ";
		final int minNumOfTokens = 5;

		StringTokenizer stringTokenizer = new StringTokenizer(s, separator);
		if (stringTokenizer.countTokens() < minNumOfTokens)
			throw new IllegalArgumentException(
					"the given string has incorrect format");
		// 1
		String stringDate = stringTokenizer.nextToken() + " "
				+ stringTokenizer.nextToken();
		Date date = null;
		try {
			date = DATE_FORMAT.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		System.out.println(date);
		//2
		String stringImportance = stringTokenizer.nextToken();
		Importance importance = null;
		importance = Importance.getImportanceBySigning(stringImportance);
		System.out.println(importance);
		//3
		String source = stringTokenizer.nextToken();
		System.out.println(source);
		//4
		String message = "";
		while(stringTokenizer.hasMoreTokens())
			message+=stringTokenizer.nextToken()+' ';
		
		//System.out.println(message);
		

		

		// String subString = source.substring(0, DATE_PATTERN.length());
		// Date date = null;
		// try {
		// date = DATE_FORMAT.parse(source);
		// } catch (ParseException e) {
		// e.printStackTrace();
		// }
		// System.out.println(date);
	}
}
