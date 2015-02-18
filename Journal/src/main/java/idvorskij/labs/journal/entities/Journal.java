package idvorskij.labs.journal.entities;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static idvorskij.labs.journal.staticinfo.StaticInfo.*;

public class Journal implements Serializable{

	public Journal(
			@Min(JOURNAL_ID_MIN_CONSTRAINT) int id,
			@NotNull ErrorType type,
			@NotNull @Size(min = JOURNAL_NAME_MIN_SIZE_CONSTRAINT, max = JOURNAL_NAME_MAX_SIZE_CONSTRAINT) String name,
			@NotNull @Size(min = JOURNAL_CAUSE_MIN_SIZE_CONSTRAINT, max = JOURNAL_CAUSE_MAX_SIZE_CONSTRAINT) String cause,
			@NotNull @Size(min = 5, max = 256) String description,
			@NotNull Timestamp date) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.cause = cause;
		this.description = description;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(@Min(JOURNAL_ID_MIN_CONSTRAINT) int id) {
		this.id = id;
	}

	public ErrorType getType() {
		return type;
	}

	public void setType(@NotNull ErrorType type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(
			@NotNull 
			@Size(min = JOURNAL_NAME_MIN_SIZE_CONSTRAINT, max = JOURNAL_NAME_MAX_SIZE_CONSTRAINT) 
			String name) {
		this.name = name;
	}

	public java.sql.Timestamp getDate() {
		return date;
	}

	public void setDate(@NotNull java.sql.Timestamp date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(
			@NotNull 
			@Size(min = JOURNAL_DESCRIPTION_MIN_SIZE_CONSTRAINT, max = JOURNAL_DESCRIPTION_MAX_SIZE_CONSTRAINT)
			String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Journal [id=" + id + ", type=" + type + ", name=" + name
				+ ", description=" + description + ", date=" + date + "]";
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	@Min(JOURNAL_ID_MIN_CONSTRAINT)
	private int id;

	@NotNull
	private ErrorType type;

	@NotNull
	@Size(min = JOURNAL_NAME_MIN_SIZE_CONSTRAINT, max = JOURNAL_NAME_MAX_SIZE_CONSTRAINT)
	private String name;

	@NotNull
	@Size(min = JOURNAL_CAUSE_MIN_SIZE_CONSTRAINT, max = JOURNAL_CAUSE_MAX_SIZE_CONSTRAINT)
	private String cause;

	@NotNull
	@Size(min = JOURNAL_DESCRIPTION_MIN_SIZE_CONSTRAINT, max = JOURNAL_DESCRIPTION_MAX_SIZE_CONSTRAINT)
	private String description;

	@NotNull
	private java.sql.Timestamp date;
}
