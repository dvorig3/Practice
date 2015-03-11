package com.dvorskij.journal.test;

import java.util.Date;
import java.util.Random;

import com.dvorskij.journal.pojo.Importance;
import com.dvorskij.journal.pojo.Record;
import com.dvorskij.journal.services.CollectionJournal;
import com.dvorskij.journal.services.Journal;

import static com.dvorskij.journal.test.RandomGenerator.*;

public class Test {
	
	public static void main(String[] args) {
		Random rand = new Random();
		Journal journal = new CollectionJournal();
		for(int i = 0; i < 100; i++){
			journal.add(new Record(getRandomDate(), Importance.getImportanceBySigning(getRandomImportanceSigningGenerator()),  getRandomString(10) , getRandomString(15)));
		}
		
		try{
			journal.add(new Record(null, Importance.SERIOUS_ERROR, null ,null));
		}catch(Exception e){
			System.err.println("SOME PARAMETER HAS NULL VALUE");
			e.printStackTrace();
		}
		try{
			journal.add(new Record(new Date(), Importance.SERIOUS_ERROR, "hgng nh" ,"ffhf fdd dd"));
		}catch(Exception e){
			System.err.println("PARAMETER SOURCE CONTAINS SPACE");
			e.printStackTrace();
		}
		//journal.printRecords();
		
		journal.sortByImportanceDate();
		journal.printRecords();
	}

}
