package com.shreyas.de.jobboard.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "JobListing")
public class Jobs {

    private String profile;
    private String description;
    private int experience;
    private String[] skills;

}
