package com.shreyas.de.jobboard.resource;

import com.shreyas.de.jobboard.model.Jobs;
import com.shreyas.de.jobboard.repository.JobsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
public class JobBoardController {

    private final JobsRepository jobsRepository;

    @GetMapping(value = "/jobs")
    public List<Jobs> getJobs(){
        return jobsRepository.findAll();
    }

    @PostMapping(value="/job")
    public Jobs saveJob(@RequestBody Jobs job){
        return jobsRepository.save(job);
    }
    
    
}
