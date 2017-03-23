package moviedatabase;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import movie.IDList;
import movie.Movie;
import movie.MovieList;
import movie.UniqueID;

public class MovieDatabase implements IMovieDatabase {

	// Get all movies
	@Override
	public MovieList getMovies() {
		return MovieList.getInstance();
	}

	// Get movie by id
	@Override
	public Movie getMovie(int id) {
		for(Movie item : MovieList.getInstance().movieDatabase) {
			if(item.getId() == id) {
				return item;
			}
		}
		throw new WebApplicationException(Response.Status.NOT_FOUND);
	}

	// Add a movie, server gives the id
	@Override
	public UniqueID addMovie(Movie movie) {
		boolean isFree = true;
		boolean addable = false;
		
		while(!addable) {
			isFree = true;
			UniqueID.getInstance().id++;
			for (Movie item : MovieList.getInstance().movieDatabase) {
				if (item.getId() == UniqueID.getInstance().id) {
					isFree = false;
				}
			}
			if (isFree) {
				addable = true;
			}
		}
		
		movie.setId(UniqueID.getInstance().id);
		MovieList.getInstance().movieDatabase.add(movie);
		return UniqueID.getInstance();
	}

	// Add or modify movie, client gives the id
	@Override
	public void addOrModifyMovie(int id, Movie movie) {
		for(Iterator<Movie> i = MovieList.getInstance().movieDatabase.iterator(); i.hasNext();) {
			Movie item = i.next();
			if(item.getId() == id) {
				i.remove();
			}
		}
		movie.setId(id);
		MovieList.getInstance().movieDatabase.add(movie);
	}

	// Delete movie by id
	@Override
	public void deleteMovie(int id) {
		for(Iterator<Movie> i = MovieList.getInstance().movieDatabase.iterator(); i.hasNext();) {
			Movie item = i.next();
			if(item.getId() == id) {
				i.remove();
			}
		}
	}

	// Find movie by year and order by "orderby" parameter
	@Override
	public IDList findMovies(int year, String orderby) {
		List<Movie> movieList = new ArrayList<Movie>();
		for(Movie item : MovieList.getInstance().movieDatabase) {
			if(item.getYear() == year) {
				movieList.add(item);
			}
		}
		if(orderby.equals("Title") || orderby.equals("title")) {
			movieList.sort(new Comparator<Movie>() {
				@Override
				public int compare(Movie o1, Movie o2) {
					return o1.getTitle().compareTo(o2.getTitle());
				}
			});
		}
		else if(orderby.equals("Director") || orderby.equals("director")) {
			movieList.sort(new Comparator<Movie>() {
				@Override
				public int compare(Movie o1, Movie o2) {
					return o1.getDirector().compareTo(o2.getDirector());
				}
			});
		}
		else {
			throw new WebApplicationException(Response.Status.BAD_REQUEST);
		}
		
		IDList resultList = new IDList();
		
		for(Movie item : movieList) {
			resultList.idList.add(item.getId());
		}
		
		return resultList;
	}

}
