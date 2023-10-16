package com.shreyas.de.jobboard.resource;

import com.shreyas.de.jobboard.model.Jobs;
import com.shreyas.de.jobboard.repository.JobSearchRepository;
import com.shreyas.de.jobboard.repository.JobsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class JobBoardController {

    private final JobsRepository jobsRepository;
    private final JobSearchRepository jobSearchRepository;

    @GetMapping(value = "/jobs")
    public List<Jobs> getJobs(){
        return jobsRepository.findAll();
    }

    @GetMapping(value = "/jobs/{text}")
    public List<Jobs> searchJobs(@PathVariable("text") String text){
        return jobSearchRepository.findJobsByText(text);
    }

    @PostMapping(value="/job")
    public Jobs saveJob(@RequestBody Jobs job){
        return jobsRepository.save(job);
    }
    
    
}
