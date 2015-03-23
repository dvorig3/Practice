package idvorskij.labs.journal.entities;

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
	FATAL_ERROR(1, "!!!!!", "red"),
	/**
	 * 
	 */
	SERIOUS_ERROR(2, "!!!  ", "orange"),
	/**
	 * 
	 */
	WARNING(3, "!    ", "yellow"),
	/**
	 * 
	 */
	RECOVERY(4, ".    ", "green");

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

	public static Importance getImportanceByImportanceNumber(int impNum) {

		switch (impNum) {
		case 1:
			return FATAL_ERROR;
		case 2:
			return SERIOUS_ERROR;
		case 3:
			return WARNING;
		case 4:
			return RECOVERY;
		default:
			return null;
		}

	}
 
	/**
	 * 
	 * @return the signing of the error
	 */
	public String getSigning() {
		return signing;
	}

	// private constructor to prohibit creating new instances
	private Importance(int importance, String signing, String color) {
		this.importanceNumber = importance;
		this.signing = signing;
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	private final int importanceNumber;
	private final String color;
	private final String signing;

}
