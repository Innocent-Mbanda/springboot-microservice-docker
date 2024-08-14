package company_service.company.Review;

import company_service.company.Company.Entity.CompanyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {
    List<ReviewEntity> getAllReviewsPerCompany(Long id); //method to return list of review>

}
