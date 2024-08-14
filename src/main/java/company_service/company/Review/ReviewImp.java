package company_service.company.Review;

import company_service.company.Company.Entity.CompanyEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewImp implements ReviewService {
    ReviewRepo reviewRepo;

    public ReviewImp(ReviewRepo reviewRepo) {
        this.reviewRepo = reviewRepo;
    }

    @Override
    public List<ReviewEntity> getAllReviewsPerCompany(Long id) {
        return reviewRepo.findByCompanyId(id);
    }

}
