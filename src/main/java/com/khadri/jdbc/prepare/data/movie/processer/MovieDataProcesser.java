package com.khadri.jdbc.prepare.data.movie.processer;


import java.util.Scanner;

import com.khadri.jdbc.prepare.data.movie.Movie;
import com.khadri.jdbc.prepare.data.movie.dao.MovieInsertDao;

public class MovieDataProcesser {
	private Scanner scanner;
	private MovieInsertDao insertDao5;
	//private Movie movie;

	public MovieDataProcesser(Scanner scanner, MovieInsertDao insertDao2) {
		this.scanner = scanner;
		this.insertDao5 = insertDao5;
	}

	
	public void process(int recordNumbr)   {
try {
	

		System.out.println("Enter Movie_Id : ");
		int id = scanner.nextInt();

		System.out.println("Enter Movie Name : ");
		String name = scanner.next();

		 
		System.out.println("Enter Movie Budeget : ");
		double movieBu = scanner.nextDouble();

		Movie movie = new Movie(id , name ,movieBu);
		 
		MovieInsertDao insertDao5= new MovieInsertDao();
		
		insertDao5.insertData(movie);
}catch(Exception e){
	System.out.println("Exception occours"+e);
	
}
}
}
