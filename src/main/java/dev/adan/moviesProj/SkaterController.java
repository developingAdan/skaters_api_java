package dev.adan.moviesProj;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

// @CrossOrigin(origins = {"http://localhost:3000"})
@RestController // we use this to communicate with our API's.
@RequestMapping("/api/v1/skaters")

public class SkaterController {
    @Autowired
    private SkaterService skaterService; // here is the reference to our service class

    @GetMapping // this is the "GET" method"
    public ResponseEntity<List<Skater>> getAllMovies() {
        // here, we are returning a response entity of type List -- Movie
        return new ResponseEntity<List<Skater>>(skaterService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}") // here we are "GET", or searching for a movie with a specific ID
    public ResponseEntity<Optional<Skater>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Skater>>(skaterService.singleMovie(imdbId), HttpStatus.OK);
    }
}

// This Controller is an "API Layer". It only concerns itself with getting a
// request
// from the User, returning the response, and nothing else. It is using a
// Service class
// and delegating the task of fetching all the movies from the DB, and giving it
// back to the API Layer
