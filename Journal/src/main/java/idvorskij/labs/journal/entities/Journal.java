package idvorskij.labs.journal.entities;

import java.sql.Timestamp;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Journal {

	public Journal(@Min(0) int id, @NotNull ErrorType type,
			@NotNull @Size(min = 5, max = 50) String name,
			@NotNull @Size(min = 5, max = 256) String description,
			@NotNull Timestamp date) {
		this.id = id;
		this.type = type;
		this.name = name;
		this.description = description;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(@Min(0) int id) {
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

	public void setName(@NotNull @Size(min = 5, max = 50) String name) {
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
			@NotNull @Size(min = 5, max = 256) String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Journal [id=" + id + ", type=" + type + ", name=" + name
				+ ", description=" + description + ", date=" + date + "]";
	}
	
	@Min(0)
	private int id;

	@NotNull
	private ErrorType type;

	@NotNull(message="Имя должно быть задано")
	@Size(min = 5, max = 50)
	private String name;

	@NotNull
	@Size(min = 5, max = 256)
	private String description;

	@NotNull
	private java.sql.Timestamp date;
}
