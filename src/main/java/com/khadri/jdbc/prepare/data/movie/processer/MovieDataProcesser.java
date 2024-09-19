package com.khadri.jdbc.prepare.data.movie.processer;

import java.util.Scanner;

import com.khadri.jdbc.prepare.data.movie.Movie;
import com.khadri.jdbc.prepare.data.movie.dao.MovieInsertDao;

public class MovieDataProcesser {
	private Scanner scanner;
	private MovieInsertDao movieDao;

	public MovieDataProcesser(Scanner scanner, MovieInsertDao movieDao) {
		this.scanner = scanner;
		this.movieDao = movieDao;
	}

	public void process(int recordNumber) {
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
}
