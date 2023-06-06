package dev.adan.moviesProj;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

// This file would be considered the Movie Model

@Document(collection = "skaters")
// ^ this will let the framework know that this class should present each
// document in the collection
@Data
// ^ an annotation that comes from Lombok. It takes care of all the different
// setters/getters

@AllArgsConstructor
// ^ an annotation that comes from Lombok. Creates a constructor that takes all
// the private fields, as arguments

@NoArgsConstructor
// ^ annotation from Lombok. Creates another constructor that takes no
// parameters

public class Skater {

    @Id
    // ^ this will let the framework know that this property should be treated
    // as the unique identifier for each movie inside the database
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;

    @DocumentReference
    // ^ this will cause the DB to store only the ID's of the review.
    // And the reviews will be in a separate collection.
    // this is called Manual Reference Relationship

    private List<Review> reviewIds;

}
