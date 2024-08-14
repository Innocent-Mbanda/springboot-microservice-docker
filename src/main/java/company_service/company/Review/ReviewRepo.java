package company_service.company.Review;

import company_service.company.Company.Entity.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepo extends JpaRepository<ReviewEntity, Long> {

    List<ReviewEntity> findByCompanyId(Long company_id);
}
