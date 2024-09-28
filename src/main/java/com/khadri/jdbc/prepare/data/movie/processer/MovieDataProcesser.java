package com.khadri.jdbc.prepare.data.movie.processer;

import java.util.List;
import java.util.Scanner;

import com.khadri.jdbc.prepare.data.movie.Movie;
import com.khadri.jdbc.prepare.data.movie.dao.MovieDao;

public class MovieDataProcesser {
	private Scanner scanner;
	private MovieDao movieDao;

	{
		this.movieDao = new MovieDao();
	}

	public MovieDataProcesser(Scanner scanner) {
		this.scanner = scanner;

	}

	public void insertProcess(int recordNumber) {
		try {
			System.out.println(recordNumber + " Record Reading starts");

			System.out.println("Enter Movie_Id : ");
			int id = scanner.nextInt();

			System.out.println("Enter Movie Name : ");
			String name = scanner.next();

			System.out.println("Enter Movie Budeget : ");
			double movieBudget = scanner.nextDouble();

			System.out.println(recordNumber + " Record Reading ends ");

			Movie movie = new Movie(id, name, movieBudget);
			movieDao.movieInsertData(movie);

		} catch (Exception e) {
			System.out.println("MovieDataProcesser Exception occours" + e);

		}
	}

	public void selectProcess(int recordNumber) {
		try {
			System.out.println(recordNumber + " Record Reading starts");
			List<Movie> listOfMovies = movieDao.movieSelectData();
			listOfMovies.stream().forEach(eachMovie -> {
				System.out.println(
						eachMovie.getMovieId() + " " + eachMovie.getMovieName() + "  " + eachMovie.getMovieBudeget());
			});
			System.out.println(recordNumber + " Record Reading ends ");
		} catch (Exception e) {
			System.out.println("MovieDataProcesser Exception occours" + e);
		} finally {
			System.out.println("Reading ends ");
		}
	}

	public void updateProcess() {
		try {
			System.out.println(" Record Reading starts");

			System.out.println("Enter Movie_Id to updated : ");
			int id = scanner.nextInt();

			System.out.println("Enter new Movie Name : ");
			String name = scanner.next();

			System.out.println("Enter  new Movie Budeget : ");
			double movieBudget = scanner.nextDouble();

			System.out.println(" Record Reading ends ");

			Movie movie = new Movie(id, name, movieBudget);
			int movieUpdateData = movieDao.movieUpdateData(movie);
			if (movieUpdateData == 1) {
				System.out.println("movie deta update succesfully");
			} else {
				System.out.println("movie update failed");
			}
		} catch (Exception e) {
			System.out.println("MovieUpdateDataProcesser Exception occours" + e);
		}
	}

	public void deleteProcess() {
		try {
			System.out.println("Enter Movie id to delete: ");
			int id = scanner.nextInt();

			int isDeleted = movieDao.deleteMovieData(id);

			if (isDeleted == 2) {
				System.out.println("Movie deleted successfully.");
			} else {
				System.out.println("movie delete failed.");
			}
		} catch (Exception e) {
			System.out.println("DeleteMovie Exception occurs: " + e);
		}
	}
}
