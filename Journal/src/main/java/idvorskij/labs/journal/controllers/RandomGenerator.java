package idvorskij.labs.journal.controllers;

import java.util.Date;
import java.util.Random;

public class RandomGenerator {
	private static Random random = new Random();

	// for string generator
	private static int startUp = (int) 'A';
	private static int finishUp = (int) 'Z';
	private static int startLow = (int) 'a';
	private static int finishLow = (int) 'z';

	// for date generator

	public static String getRandomString(int size) {
		if (size == 0)
			return "";
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < size; ++i) {
			res.append(getRandomChar());
		}
		return res.toString();
	}

	@SuppressWarnings("deprecation")
	public static Date getRandomDate() {
		Date d = new Date();
		d.setHours(random.nextInt(24) + 1);
		d.setMinutes(random.nextInt(12) + 1);
		return d;
	}

	public static char getRandomChar() {
		// choice if upper 0 or lower case 1
		int choice = random.nextInt(2);
		return (char) (choice == 0 ? random.nextInt(finishUp - startUp)
				+ startUp : random.nextInt(finishLow - startLow) + startLow);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; ++i)
			System.out.println(getRandomString(100));
	}

	public static String getRandomImportanceSigningGenerator() {
		int imp = random.nextInt(4) + 1;
		return imp == 1 ? "." : imp == 2 ? "!" : imp == 3 ? "!!!" : "!!!!!";
	}
}
