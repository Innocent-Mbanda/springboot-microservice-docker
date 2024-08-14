package company_service.company.Company.Repo;

import company_service.company.Company.Entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepo extends JpaRepository<CompanyEntity, Long> {
}
