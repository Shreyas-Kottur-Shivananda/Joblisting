package com.shreyas.de.jobboard.repository;

import com.shreyas.de.jobboard.model.Jobs;

import java.util.List;

public interface JobSearchRepository {

    List<Jobs> findJobsByText(String text);
}
