package company_service.company.Job.Repository;


import company_service.company.Job.Entity.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<JobEntity, Long> {
    
}
