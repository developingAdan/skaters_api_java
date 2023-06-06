package dev.adan.moviesProj;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkaterRepository extends MongoRepository<Skater, ObjectId> {
    Optional<Skater> findMovieByImdbId(String imdbId);
}

// The Repository Layer (this layer) is the data access layer for our API.
// It does the job of actually communicating with the DB and getting the Data
// back