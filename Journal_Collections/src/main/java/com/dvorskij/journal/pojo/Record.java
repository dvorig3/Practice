package com.dvorskij.journal.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

public final class Record {

	/**
	 * 
	 * @param date
	 * @param importance
	 * @param source
	 * @param message
	 * @throws NullPointerException
	 * @throws IllegalArgumentException
	 */
	public Record(Date date, Importance importance, String source,
			String message) throws NullPointerException,
			IllegalArgumentException {
		if (date == null || source == null || message == null)
			throw new NullPointerException("some parameter has a null value");
		if (source.matches(".* .*"))
			throw new IllegalArgumentException(
					"parameter source could not contain any space");
		this.source = source;
		this.date = date;
		this.importance = importance;
		this.message = message;
	}

	public Record(String s) throws ParseException, NullPointerException {
		// 0
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
		date = DATE_FORMAT.parse(stringDate);

		// 2
		String stringImportance = stringTokenizer.nextToken();
		Importance importance = null;
		importance = Importance.getImportanceBySigning(stringImportance);

		if (importance == null)
			throw new NullPointerException("no such error importance");

		// 3
		String source = stringTokenizer.nextToken();

		// 4
		String message = "";
		while (stringTokenizer.hasMoreTokens())
			message += stringTokenizer.nextToken() + ' ';

		this.date = date;
		this.importance = importance;
		this.source = source;
		this.message = message;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Record other = (Record) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (importance != other.importance)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (source == null) {
			if (other.source != null)
				return false;
		} else if (!source.equals(other.source))
			return false;
		return true;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the importance
	 */
	public Importance getImportance() {
		return importance;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result
				+ ((importance == null) ? 0 : importance.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((source == null) ? 0 : source.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return DATE_FORMAT.format(date) + ' ' + importance.getSigning() + ' '
				+ source + ' ' + message;
	}

	private final Date date;

	private final Importance importance;

	private final String message;

	private final String source;
	
	
	private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat(
			DATE_PATTERN);

}
