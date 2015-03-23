package idvorskij.labs.journal.entities;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static idvorskij.labs.journal.staticinfo.StaticInfo.*;

/**
 * 
 * @author Igor Dvorskij
 * 
 *         This class describes the entity bean Journal that is basic bean
 *
 */
public class Jour implements Serializable {

//	/**
//	 * 
//	 * @param id
//	 *            value of Error (the value generally extracted from database)
//	 * @param type
//	 *            of Error (any instance of the enumeration ErrorType)
//	 * @param name
//	 *            of Error (any name or special error name)
//	 * @param cause
//	 *            of Error (the cause or the stack trace)
//	 * @param description
//	 *            of Error (the short description gotten from user)
//	 * @param date
//	 *            of Error (the time error was detected)
//	 */
//	public Journal(
//			@Min(JOURNAL_ID_MIN_CONSTRAINT) int id,
//			@NotNull ErrorType type,
//			@NotNull @Size(min = JOURNAL_NAME_MIN_SIZE_CONSTRAINT, max = JOURNAL_NAME_MAX_SIZE_CONSTRAINT) String name,
//			@NotNull @Size(min = JOURNAL_CAUSE_MIN_SIZE_CONSTRAINT, max = JOURNAL_CAUSE_MAX_SIZE_CONSTRAINT) String cause,
//			@NotNull @Size(min = 5, max = 256) String description,
//			@NotNull Timestamp date) {
//		this.id = id;
//		this.type = type;
//		this.name = name;
//		this.cause = cause;
//		this.description = description;
//		this.date = date;
//	}
//
//	/**
//	 * 
//	 * @return id value of Error (the value generally extracted from database)
//	 */
//	public int getId() {
//		return id;
//	}
//
//	/**
//	 * 
//	 * @param id
//	 *            value of Error (the value generally extracted from database)
//	 */
//	public void setId(@Min(JOURNAL_ID_MIN_CONSTRAINT) int id) {
//		this.id = id;
//	}
//
//	/**
//	 * 
//	 * @return type of Error (any instance of the enumeration ErrorType)
//	 */
//	public ErrorType getType() {
//		return type;
//	}
//
//	/**
//	 * 
//	 * @param type
//	 *            of Error (any instance of the enumeration ErrorType)
//	 */
//	public void setType(@NotNull ErrorType type) {
//		this.type = type;
//	}
//
//	/**
//	 * 
//	 * @return name of Error (any name or a special error name)
//	 */
//
//	public String getName() {
//		return name;
//	}
//
//	/**
//	 * 
//	 * @param name
//	 *            of Error (any name or a special error name)
//	 */
//	public void setName(
//			@NotNull @Size(min = JOURNAL_NAME_MIN_SIZE_CONSTRAINT, max = JOURNAL_NAME_MAX_SIZE_CONSTRAINT) String name) {
//		this.name = name;
//	}
//
//	/**
//	 * 
//	 * @return date of Error (the time error was detected)
//	 */
//	public java.sql.Timestamp getDate() {
//		return date;
//	}
//
//	/**
//	 * 
//	 * @param date
//	 *            of Error (the time error was detected)
//	 */
//	public void setDate(@NotNull java.sql.Timestamp date) {
//		this.date = date;
//	}
//
//	/**
//	 * 
//	 * @return description of Error (the short description gotten from user)
//	 */
//	public String getDescription() {
//		return description;
//	}
//
//	/**
//	 * 
//	 * @param description
//	 *            of Error (the short description gotten from user)
//	 */
//	public void setDescription(
//			@NotNull @Size(min = JOURNAL_DESCRIPTION_MIN_SIZE_CONSTRAINT, max = JOURNAL_DESCRIPTION_MAX_SIZE_CONSTRAINT) String description) {
//		this.description = description;
//	}
//
//	@Override
//	public String toString() {
//		return "Journal [id=" + id + ", type=" + type + ", name=" + name
//				+ ", description=" + description + ", date=" + date + "]";
//	}
//
//	/**
//	 * 
//	 * @return cause of Error (the cause or the stack trace)
//	 */
//	public String getCause() {
//		return cause;
//	}
//
//	/**
//	 * 
//	 * @param cause
//	 *            of Error (the cause or the stack trace)
//	 */
//	public void setCause(String cause) {
//		this.cause = cause;
//	}
//
//	@Min(JOURNAL_ID_MIN_CONSTRAINT)
//	private int id;
//
//	@NotNull
//	private ErrorType type;
//
//	@NotNull
//	@Size(min = JOURNAL_NAME_MIN_SIZE_CONSTRAINT, max = JOURNAL_NAME_MAX_SIZE_CONSTRAINT)
//	private String name;
//
//	@NotNull
//	@Size(min = JOURNAL_CAUSE_MIN_SIZE_CONSTRAINT, max = JOURNAL_CAUSE_MAX_SIZE_CONSTRAINT)
//	private String cause;
//
//	@NotNull
//	@Size(min = JOURNAL_DESCRIPTION_MIN_SIZE_CONSTRAINT, max = JOURNAL_DESCRIPTION_MAX_SIZE_CONSTRAINT)
//	private String description;
//
//	@NotNull
//	private java.sql.Timestamp date;
//
//	private static final long serialVersionUID = -5759640333698196979L;
}
