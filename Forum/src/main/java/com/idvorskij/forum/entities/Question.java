package com.idvorskij.forum.entities;

import java.io.Serializable;
import java.util.Date;

public class Question implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param id
	 * @param user
	 * @param topicId
	 * @param date
	 * @param content
	 * @param answerNumber
	 */
	public Question(int id, User user, int topicId, Date date, String content,
			int answerNumber) {
		this.id = id;
		this.user = user;
		this.topicId = topicId;
		this.date = date;
		this.content = content;
		this.answerNumber = answerNumber;
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
		Question other = (Question) obj;
		if (answerNumber != other.answerNumber)
			return false;
		if (content == null) {
			if (other.content != null)
				return false;
		} else if (!content.equals(other.content))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (id != other.id)
			return false;
		if (topicId != other.topicId)
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

	/**
	 * @return the answerNumber
	 */
	public int getAnswerNumber() {
		return answerNumber;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the topicId
	 */
	public int getTopicId() {
		return topicId;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
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
		result = prime * result + answerNumber;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + id;
		result = prime * result + topicId;
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		return result;
	}

	/**
	 * @param answerNumber
	 *            the answerNumber to set
	 */
	public void setAnswerNumber(int answerNumber) {
		this.answerNumber = answerNumber;
	}

	/**
	 * @param content
	 *            the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @param date
	 *            the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @param topicId
	 *            the topicId to set
	 */
	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	/**
	 * @param user
	 *            the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [id=" + id + ", user=" + user + ", topicId=" + topicId
				+ ", date=" + date + ", content=" + content + ", answerNumber="
				+ answerNumber + "]";
	}

	private int answerNumber;
	private String content;
	private Date date;
	private int id;
	private int topicId;
	private User user;

}
