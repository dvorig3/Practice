package com.idvorskij.forum.entities;

import java.io.Serializable;

public class Topic implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param content
	 * @param questionsAmount
	 */
	public Topic(int id, String content, int questionsAmount) {
		this.id = id;
		this.content = content;
		this.questionsAmount = questionsAmount;
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
		Topic other = (Topic) obj;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (id != other.id)
			return false;
		if (questionsAmount != other.questionsAmount)
			return false;
		return true;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
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
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + id;
		result = prime * result + questionsAmount;
		return result;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Topic [id=" + id + ", content=" + content
				+ ", questionsAmount=" + questionsAmount + "]";
	}

	private String content;
	private int id;
	private int questionsAmount;

	/**
	 * @return the questionsAmount
	 */
	public int getQuestionsAmount() {
		return questionsAmount;
	}

	/**
	 * @param questionsAmount the questionsAmount to set
	 */
	public void setQuestionsAmount(int questionsAmount) {
		this.questionsAmount = questionsAmount;
	}
}
