package com.cognizant.model;

public class Ideas {
	int ideaId;
	String category;
	String description;
	int voteup;
	int votedown;
	String comments;
	int enrolnumber;

	public int getEnrolnumber() {
		return enrolnumber;
	}

	public void setEnrolnumber(int enrolnumber) {
		this.enrolnumber = enrolnumber;
	}

	public int getIdeaId() {
		return ideaId;
	}

	public void setIdeaId(int ideaId) {
		this.ideaId = ideaId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getVoteup() {
		return voteup;
	}

	public void setVoteup(int voteup) {
		this.voteup = voteup;
	}

	public int getVotedown() {
		return votedown;
	}

	public void setVotedown(int votedown) {
		this.votedown = votedown;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

}
