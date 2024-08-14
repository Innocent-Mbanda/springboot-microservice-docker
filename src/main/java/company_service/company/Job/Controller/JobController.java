package company_service.company.Job.Controller;


import company_service.company.Job.Entity.JobEntity;
import company_service.company.Job.Exception.JobNotFoundException;
import company_service.company.Job.JobService.JobService;
import company_service.company.Job.Model.Job;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/v1jobs")
public class JobController {

    private final JobService jobService;
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/jobs")
    public String createJobs(@RequestBody Job job){
        jobService.CreateJob(job);
        return "Job created successfully";
    }


    //method to return list of jobs;
    @GetMapping("/jobs")
    private ResponseEntity<List<JobEntity>> findAllJobs(){
      return ResponseEntity.ok().body(jobService.findAll());
    }

    @GetMapping("/Jobs/{id}")
    public ResponseEntity<JobEntity> getJobById(@PathVariable Long id) throws JobNotFoundException {
        JobEntity job = jobService.findJobId(id);
        if (job !=null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        else
        {
            throw new JobNotFoundException("Job not found");
        }
    }


    @DeleteMapping("/Jobs/{id}")
    public ResponseEntity<JobEntity>deleteJobById(@PathVariable Long id) throws JobNotFoundException {
     JobEntity job = jobService.findJobId(id);
        if (job !=null) {
            jobService.deleteJob(id,"Job deleted successfully");
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        else
        {
            throw new JobNotFoundException("Job not found");
        }
    }
    @PutMapping("/Jobs/{id}")
    public ResponseEntity<String>updateJob(@PathVariable Long id, @RequestBody Job updatedJob){
       Boolean update = jobService.updateJob(id, updatedJob);
    if (update){
        return new ResponseEntity<>("jobs is updated",HttpStatus.OK);
    }
        return new ResponseEntity<>("jobs is not updated",HttpStatus.NOT_FOUND);
    }
}



