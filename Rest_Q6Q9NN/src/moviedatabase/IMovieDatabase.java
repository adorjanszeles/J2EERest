package moviedatabase;

import javax.ws.rs.core.MediaType;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import movie.IDList;
import movie.Movie;
import movie.MovieList;
import movie.UniqueID;

@Path("MovieDatabase")
public interface IMovieDatabase {
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("movies")
	public MovieList getMovies();
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("movies/{id}")
	public Movie getMovie(@PathParam("id") int id);
	
	@POST
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("movies")
	public UniqueID addMovie(Movie movie);
	
	@PUT
	@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("movies/{id}")
	public void addOrModifyMovie(@PathParam("id") int id, Movie movie);
	
	@DELETE
	@Path("movies/{id}")
	public void deleteMovie(@PathParam("id") int id);
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("movies/find")
	public IDList findMovies(@QueryParam("year") int year, @QueryParam("orderby") String orderby);

}
