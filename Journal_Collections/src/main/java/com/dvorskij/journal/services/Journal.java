package com.dvorskij.journal.services;

import java.util.Date;
import java.util.List;
import com.dvorskij.journal.jb.Record;

public interface Journal {
	/**
	 * this method returns the list of all the records of Journal
	 * @return list
	 */
	public List<Record> getJournal();

	/**
	 * this method adds all the records from an other journal to this
	 * 
	 * @param journal
	 */
	void add(Journal journal) throws NullPointerException;

	/**
	 * this method adds a new record to the Journal
	 * 
	 * @param record
	 */
	void add(Record record) throws NullPointerException;

	/**
	 * this method returns the new instance of filtered Journal that consists of
	 * the records that date is between fromDate and toDate
	 * 
	 * @param fromDate
	 * @param toDate
	 * @return filtered journal
	 */
	Journal filter(Date fromDate, Date toDate) throws NullPointerException;
	/**
	 * this method returns the new instance of filtered Journal that consists of
	 * records that string representation (toString() is the same to parameter s
	 * 
	 * @param s
	 * @return filtered journal
	 */
	Journal filter(String s) throws NullPointerException;

	/**
	 * this method returns the record by index
	 * 
	 * @param index
	 * @return
	 */
	Record get(int index) throws IndexOutOfBoundsException;

	/**
	 * this method inserts a new record to journal at the index position with
	 * shifting other record to right on one step
	 * 
	 * @param index
	 * @param record
	 */
	void insert(int index, Record record) throws IndexOutOfBoundsException, NullPointerException;

	/**
	 * print all the records in System.out PrintStream 
	 */
	void printRecords();

	/**
	 * this method removes a record by index
	 * 
	 * @param index
	 */
	void remove(int index) throws IndexOutOfBoundsException;

	/**
	 * this method removes all the records in range from fromIndex to toIndex
	 * 
	 * @param fromIndex
	 * @param toIndex
	 */
	void remove(int fromIndex, int toIndex) throws IndexOutOfBoundsException;

	/**
	 * this method removes a record from the journal
	 * 
	 * @param record
	 */
	void remove(Record record) throws NullPointerException;

	/**
	 * this method removes all the records from journal
	 */
	void removeAll();

	/**
	 * this method replaces a record by index to the given record
	 * 
	 * @param index
	 * @param record
	 */
	void set(int index, Record record);

	/**
	 * this method returns the size of journal
	 * 
	 * @return size
	 */
	int size();

	/**
	 * this method sorts a journal by the date
	 */
	void sortByDate();

	/**
	 * this method sorts a journal by both importance, and date; the records
	 * with the same importance are sorted by date
	 */
	void sortByImportanceDate();

	/**
	 * this method sorts a journal by both importance, source, and date
	 */
	void sortByImportanceSourceDate();

	/**
	 * this method sorts a journal by both source, and date
	 */
	void sortBySourceDate();

}
