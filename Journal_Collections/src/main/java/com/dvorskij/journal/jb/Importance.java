package com.dvorskij.journal.jb;

/**
 * 
 * @author Igor
 *
 *         this enumeration contains the types of errors and their importance
 * 
 */
public enum Importance {

	/**
	 * 
	 */
	FATAL_ERROR(1, "!!!!!"),
	/**
	 * 
	 */
	SERIOUS_ERROR(2, "!!!  "),
	/**
	 * 
	 */
	WARNING(3, "!    "),
	/**
	 * 
	 */
	RECOVERY(4, ".    ");

	/**
	 * 
	 * @return the importance of the error
	 */
	public int getImportance() {
		return importance;
	}

	/**
	 * 
	 * @return the signing of the error
	 */
	public String getSigning() {
		return signing;
	}

	// private constructor to prohibit creating new instances 
	private Importance(int importance, String signing) {
		this.importance = importance;
		this.signing = signing;
	}

	private final int importance;

	private final String signing;

}
