package com.khadri.jdbc.prepare.data.movie;

public class Movie {
	private int movieId;
	private String movieName;
	private double movieBudeget;

	public Movie(int movieId, String movieName, double movieBudeget) {

		this.movieId = movieId;
		this.movieName = movieName;
		this.movieBudeget = movieBudeget;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public double getMovieBudeget() {
		return movieBudeget;
	}

	public void setMovieBudget(double movieBudeget) {
		this.movieBudeget = movieBudeget;
	}

}
