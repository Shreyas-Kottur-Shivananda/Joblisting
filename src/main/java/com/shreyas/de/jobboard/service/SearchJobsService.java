package com.shreyas.de.jobboard.service;

import com.mongodb.client.AggregateIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.shreyas.de.jobboard.model.Jobs;
import com.shreyas.de.jobboard.repository.JobSearchRepository;
import lombok.RequiredArgsConstructor;
import org.bson.Document;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchJobsService implements JobSearchRepository {

    private final MongoClient mongoClient;
    private final MongoConverter mongoConverter;


    @Override
    public List<Jobs> findJobsByText(String text) {
        final List<Jobs> jobs = new ArrayList<>();

        MongoDatabase database = mongoClient.getDatabase("JobBoards");
        MongoCollection<Document> collection = database.getCollection("JobListing");
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(new Document("$search",
                new Document("text",
                        new Document("query", text)
                                .append("path", Arrays.asList("description", "profile", "skills"))))));
        result.forEach(doc->jobs.add(mongoConverter.read(Jobs.class,doc)));
        return jobs;
    }
}
