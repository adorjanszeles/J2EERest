package movie;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "movies")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MoviesList", propOrder = {"movieDatabase"})
@XmlSeeAlso(Movie.class)
public class MovieList {
	@XmlElement(name = "movie", type = Movie.class, nillable = true)
	public List<Movie> movieDatabase = null;
	
	private static MovieList instance = null;
	
	protected MovieList() {
		movieDatabase = new ArrayList<Movie>();
	}

	public static MovieList getInstance() {
		if(instance == null) {
			instance = new MovieList();
		}
		return instance;
	}

}
