package dev.adan.moviesProj;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SkaterService {
    // inside here, we write the database access methods

    @Autowired // this will tell the Framework that we want the Framework to instantiate this
               // class for us
    private SkaterRepository skaterRepository; // this is where we create a reference to the repo

    public List<Skater> allMovies() {
        return skaterRepository.findAll();
    }

    public Optional<Skater> singleMovie(String imdbId) {
        return skaterRepository.findMovieByImdbId(imdbId);
    }

    // Overall, what this service class does is it uses the Repository Class and
    // talks to
    // the DB, gets the list of movies, and returns that to the API Layer
}
