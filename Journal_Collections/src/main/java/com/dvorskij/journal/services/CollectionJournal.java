package com.dvorskij.journal.services;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import com.dvorskij.journal.pojo.Record;

public class CollectionJournal implements Journal {

	public void add(Journal journal) throws NullPointerException {
		if (journal == null)
			throw new NullPointerException();
		this.journal.addAll(journal.getJournal());
	}

	public void add(Record record) throws NullPointerException {
		if (record == null)
			throw new NullPointerException();
		journal.add(record);
	}

	public Journal filter(Date fromDate, Date toDate)
			throws NullPointerException {
		if (fromDate == null || toDate == null)
			throw new NullPointerException();
		Journal subJ = new CollectionJournal();
		for (Record record : journal) {
			if (record.getDate().after(fromDate)
					&& record.getDate().before(toDate))
				subJ.add(record);
		}
		return subJ;
	}

	public Journal filter(String s) throws ParseException, NullPointerException  {
		if (s == null)
			throw new NullPointerException();
		Record record = new Record(s);
		Journal subJ = new CollectionJournal();
		for (Record r : journal) {
			if (record.equals(r))
				subJ.add(r);
		}
		return subJ;
	}

	public Record get(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size() - 1)
			throw new IndexOutOfBoundsException();
		return journal.get(index);
	}

	public List<Record> getJournal() {
		return journal;
	}

	public void insert(int index, Record record)
			throws IndexOutOfBoundsException, NullPointerException {
		if (index < 0 || index > size() - 1)
			throw new IndexOutOfBoundsException();
		if (record == null)
			throw new NullPointerException();
		journal.add(index, record);
	}

	public void printRecords() {
		for (int i = 0; i < size(); ++i) {
			System.out.println(get(i).toString());
		}
	}

	public void remove(int index) throws IndexOutOfBoundsException {
		if (index < 0 || index > size() - 1)
			throw new IndexOutOfBoundsException();
		journal.remove(index);
	}

	public void remove(int fromIndex, int toIndex)
			throws IndexOutOfBoundsException {
		if (fromIndex > toIndex || fromIndex < 0 || fromIndex > size() - 1
				|| toIndex > size() - 1)
			throw new IndexOutOfBoundsException();
		ArrayList<Record> sublist = (ArrayList<Record>) journal.subList(
				fromIndex, toIndex);
		journal.removeAll(sublist);
	}

	public void remove(Record record) throws NullPointerException {
		if (record == null)
			throw new NullPointerException();
		remove(record);

	}

	public void removeAll() {
		journal.clear();
	}

	public void set(int index, Record record) throws IndexOutOfBoundsException,
			NullPointerException {
		if (index < 0 || index > size() - 1)
			throw new IndexOutOfBoundsException();
		if (record == null)
			throw new NullPointerException();
		journal.set(index, record);

	}

	public int size() {
		return journal.size();
	}

	public void sortByDate() {
		Collections.sort(journal, COMPARE_BY_DATE);
	}

	public void sortByImportanceDate() {
		Collections.sort(journal, COMPARE_BY_IMPORTANCE_DATE);
	}

	public void sortByImportanceSourceDate() {
		Collections.sort(journal, COMPARE_BY_IMPORTANCE_SOURCE_DATE);

	}

	public void sortBySourceDate() {
		Collections.sort(journal, COMPARE_BY_SOURCE_DATE);
	}

	private List<Record> journal = new ArrayList<Record>();

	// <------------ COMPARATORS -------------->

	private static class SortByDateComparator implements Comparator<Record> {

		public int compare(Record o1, Record o2) {
			return compareDates(o1.getDate(), o2.getDate());
		}

	}

	//
	private static class SortByImportanceDateComparator implements
			Comparator<Record> {

		public int compare(Record o1, Record o2) {

			return o1.getImportance().getImportanceNumber() < o2
					.getImportance().getImportanceNumber() ? -1 : o1
					.getImportance().getImportanceNumber() > o2.getImportance()
					.getImportanceNumber() ? 1 : compareDates(o1.getDate(),
					o2.getDate());
		}

	}

	//
	private static class SortByImportanceSourceDateComparator implements
			Comparator<Record> {

		public int compare(Record o1, Record o2) {

			return o1.getImportance().getImportanceNumber() < o2
					.getImportance().getImportanceNumber() ? -1 : o1
					.getImportance().getImportanceNumber() > o2.getImportance()
					.getImportanceNumber() ? 1 : compareStringDates(
					o1.getSource(), o2.getSource(), o1.getDate(), o2.getDate());
		}

	}

	//
	private static class SortBySourceDateComparator implements
			Comparator<Record> {

		public int compare(Record o1, Record o2) {

			return compareStringDates(o1.getSource(), o2.getSource(),
					o1.getDate(), o2.getDate());
		}

	}

	/*
	 * service method to compare dates 0 - eq, -1 - d1 after d2, 1 - d1 before
	 * d2
	 */
	private static int compareDates(Date d1, Date d2) {
		return d1.equals(d2) ? 0 : d1.after(d2) ? -1 : 1;
	}

	/*
	 * service method to compare string dates comparing strings if equal than
	 * comparing dates
	 */
	private static int compareStringDates(String s1, String s2, Date d1, Date d2) {
		return s1.compareTo(s2) == 1 ? 1 : s1.compareTo(s2) == -1 ? -1
				: compareDates(d1, d2);
	}

	//
	private static Comparator<Record> COMPARE_BY_DATE = new SortByDateComparator();
	//
	private static Comparator<Record> COMPARE_BY_IMPORTANCE_DATE = new SortByImportanceDateComparator();
	//
	private static Comparator<Record> COMPARE_BY_IMPORTANCE_SOURCE_DATE = new SortByImportanceSourceDateComparator();
	//
	private static Comparator<Record> COMPARE_BY_SOURCE_DATE = new SortBySourceDateComparator();

}
