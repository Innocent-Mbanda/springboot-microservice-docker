package company_service.company.Job.JobIMP;


import company_service.company.Job.Entity.JobEntity;
import company_service.company.Job.JobService.JobService;
import company_service.company.Job.Model.Job;
import company_service.company.Job.Repository.JobRepository;
import company_service.company.Job.company.Company;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;


@Service
public class JobServiceImpl implements JobService {
    JobRepository jobRepository;
    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    //since we are not using db, we will create a list of jobs
//    List<Job>jobs = new ArrayList<>();
    @Override
    public List<JobEntity> findAll() {
        RestTemplate restTemplate = new RestTemplate();
        Company company = restTemplate.getForObject(" http://localhost:8080/companies/1", Company.class);
        assert company != null;
        System.out.println("Company: " +company.getId());
        System.out.println("Company: " +company.getCompanyName());
        return jobRepository.findAll();
    }

    /**
     * @param job
     */
    @Override
    public void CreateJob(Job job) {
        JobEntity jobEntity = new JobEntity();
        jobEntity.setTitle(job.getTitle());
        jobEntity.setLocation(job.getLocation());
        jobEntity.setJobDescription(job.getJobDescription());
        jobEntity.setMaxSalary(job.getMaxSalary());
        jobEntity.setMinSalary(job.getMinSalary());
        jobRepository.save(jobEntity);
    }

    @Override
    public JobEntity findJobId(Long id) {
//      return jobs.stream().filter(job -> job.getId().equals(id)).findFirst().orElse(null);
        return jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));

    }

    @Override
    public void deleteJob(Long id,String message) {
        JobEntity  jobInTable = jobRepository.findById(id).orElseThrow(() -> new RuntimeException("Job not found"));
        jobRepository.delete(jobInTable);
    }

    @Override
    public Boolean updateJob(Long id, Job updatedjob) {
        Optional<JobEntity> jobToUpdate = jobRepository.findById(id);
        if (jobToUpdate.isPresent()){
            JobEntity job = jobToUpdate.get();
            job.setId(updatedjob.getId());
            job.setTitle(updatedjob.getTitle());
            job.setLocation(updatedjob.getLocation());
            job.setMinSalary(updatedjob.getMinSalary());
            job.setMaxSalary(updatedjob.getMaxSalary());
            job.setJobDescription(updatedjob.getJobDescription());
            jobRepository.save(job);
            return true;
        }
        return false;
    }
}
