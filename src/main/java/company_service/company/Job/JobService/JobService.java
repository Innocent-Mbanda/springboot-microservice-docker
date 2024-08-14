package company_service.company.Job.JobService;


import company_service.company.Job.Entity.JobEntity;
import company_service.company.Job.Model.Job;


import java.util.List;

public interface JobService {
    List<JobEntity> findAll();

  void CreateJob(Job job);

  JobEntity findJobId(Long id);

    void deleteJob(Long id,String message);

    Boolean updateJob(Long id, Job updatedjob);
}
