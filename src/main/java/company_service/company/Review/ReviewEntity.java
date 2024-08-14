package company_service.company.Review;


import com.fasterxml.jackson.annotation.JsonIgnore;
import company_service.company.Company.CompanyModel.Company;
import company_service.company.Company.Entity.CompanyEntity;
import company_service.company.Job.Model.Job;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private double rating;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    private CompanyEntity company; //review belongs to <company>
}
