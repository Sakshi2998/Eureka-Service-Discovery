package com.example.bookratingservice.models;

public class Rating {

	private int bookId;
	private int rating;

	public Rating(int bookId, int rating) {
		super();
		this.bookId = bookId;
		this.rating = rating;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Rating [bookId=" + bookId + ", rating=" + rating + "]";
	}

}
