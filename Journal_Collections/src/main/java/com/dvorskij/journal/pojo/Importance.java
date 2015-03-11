package com.dvorskij.journal.pojo;

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
	public int getImportanceNumber() {
		return importanceNumber;
	}

	/**
	 * 
	 * @param signing
	 * @return Importance instance or null
	 */
	public static Importance getImportanceBySigning(String signing) {
		final String FATAL_ERROR_PATTERN = "[ ]*[!]{5}[ ]*";
		final String SERIOUS_ERROR_PATTERN = "[ ]*[!]{3}[ ]*";
		final String WARNING_PATTERN = "[ ]*[!][ ]*";
		final String RECOVERY_PATTERN = "[ ]*[.][ ]*";

		return signing.matches(RECOVERY_PATTERN) ? RECOVERY : signing
				.matches(WARNING_PATTERN) ? WARNING : signing
				.matches(SERIOUS_ERROR_PATTERN) ? SERIOUS_ERROR : signing
				.matches(FATAL_ERROR_PATTERN) ? FATAL_ERROR : null;

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
		this.importanceNumber = importance;
		this.signing = signing;
	}

	private final int importanceNumber;

	private final String signing;

}
