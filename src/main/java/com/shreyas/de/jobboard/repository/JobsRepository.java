package com.shreyas.de.jobboard.repository;

import com.shreyas.de.jobboard.model.Jobs;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends MongoRepository<Jobs,String> {
}
