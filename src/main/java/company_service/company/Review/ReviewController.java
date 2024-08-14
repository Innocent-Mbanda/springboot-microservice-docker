package company_service.company.Review;

import company_service.company.Company.Entity.CompanyEntity;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("company/{id}/")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }
//    @PostMapping("/review")
//    public ResponseEntity<ReviewEntity>createAReview(@RequestBody ReviewEntity review){
//        return ResponseEntity.ok(reviewService.createReview(review));
//
//    }
    @GetMapping("/reviews")
    public ResponseEntity<List<ReviewEntity>> getAllReviewsByCompany(@PathVariable Long id){
        return new ResponseEntity<>(reviewService.getAllReviewsPerCompany(id), HttpStatus.OK);
    }

}
