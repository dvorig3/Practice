package com.dvorskij.journal.test;

import java.util.Date;

import com.dvorskij.journal.jb.Importance;
import com.dvorskij.journal.jb.Record;
import com.dvorskij.journal.services.CollectionJournal;
import com.dvorskij.journal.services.Journal;

public class Main {

	public static void main(String[] args) {
		Record r1 = new Record(new Date(), Importance.FATAL_ERROR,
				"ExceptionRfdv", "Message");
		Record r2 = new Record(new Date(), Importance.RECOVERY, "ExceptionRtg1",
				"Message");
		Record r3 = new Record(new Date(), Importance.SERIOUS_ERROR,
				"ExceptionRdvd", "Message");
		Record r4 = new Record(new Date(), Importance.WARNING, "ExceptionRa4",
				"Message");
		Record r5 = new Record(new Date(), Importance.FATAL_ERROR,
				"ExceptionRdfv", "Message");
		Record r6 = new Record(new Date(), Importance.RECOVERY, "ExceptionR32",
				"Message");
		Record r7 = new Record(new Date(), Importance.SERIOUS_ERROR,
				"ExceptionRfdv", "Message");
		Record r8 = new Record(new Date(), Importance.WARNING, "ExceptionRr3",
				"Message");
		Record r9 = new Record(new Date(), Importance.FATAL_ERROR,
				"ExceptionRdfv", "Message");
		Record r10 = new Record(new Date(), Importance.RECOVERY, "ExceptionR34f",
				"Message");
		Record r11 = new Record(new Date(), Importance.RECOVERY, "ExceptionRwe",
				"Message");
		Record r12 = new Record(new Date(), Importance.WARNING, "ExceptionR44",
				"Message");

		CollectionJournal joural = new CollectionJournal();
		joural.add(r1);
		joural.add(r2);
		joural.add(r3);
		joural.add(r4);
		joural.add(r5);
		joural.add(r6);
		joural.add(r7);
		joural.add(r8);
		Journal jSub = new CollectionJournal();
		joural.add(r9);
		jSub.add(r10);
		jSub.add(r11);
		jSub.add(r12);
		joural.add(jSub);
		
		joural.printRecords();
		
		System.out.println("-----------------------------------------------------------------------------------------------");
		joural.sortByImportanceDate();
		joural.printRecords();
		
		System.out.println("-----------------------------------------------------------------------------------------------");
		joural.sortByImportanceSourceDate();
		joural.printRecords();
		
	}

}
