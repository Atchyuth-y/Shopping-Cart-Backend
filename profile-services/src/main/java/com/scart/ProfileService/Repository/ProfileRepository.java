package com.scart.ProfileService.Repository;

import com.scart.ProfileService.Model.Profile;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, Integer> {

    @Query("{'emailId' : ?0}")
    Optional<Profile> findByEmail(String emailId);
}
