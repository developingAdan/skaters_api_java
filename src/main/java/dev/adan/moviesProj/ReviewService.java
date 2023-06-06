package dev.adan.moviesProj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));

        mongoTemplate.update(Skater.class)
                .matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review))
                .first();

        return review;

        // what we are doing here is using the Mongo Template to perform an update call
        // on the Movie class. Each movie in our collection contains an empty arr of
        // reviewIds.
        // Here we update that array and push a new review ID onto the document in the
        // collection.
        // We are updating a movie where the IMDB ID of the movie in the DB, matches the
        // IMDB ID
        // that we have received from the User. Then we want to ^ "apply" this update.
        // To do so,
        // we call apply and then create a new Update definition, which makes the
        // changes inside
        // the DB. Then the correct data gets pushed inside "reviewIds" array
    }
}
