package com.synchrony.rishal.valueobjects;

/**
 * Value object to store the data reterieved from database for table_8.
 * 
 * @author Rishal_singh
 *
 */
public class Table_8 {
	private String title;
	private String platform;
	private double score;
	private String genre;
	private String editorsChoice;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getEditorsChoice() {
		return editorsChoice;
	}

	public void setEditorsChoice(String editorsChoice) {
		this.editorsChoice = editorsChoice;
	}

}
