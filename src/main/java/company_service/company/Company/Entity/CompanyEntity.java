package company_service.company.Company.Entity;


import company_service.company.Job.Entity.JobEntity;
import company_service.company.Job.Model.Job;
import company_service.company.Review.ReviewEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "company")
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id",nullable = false)
    private Long id;

    @Column(name = "company_name",nullable = false)
    private String companyName;

    @Column(name = "company_location",nullable = false)
    private String location;

    @Column(name = "description",nullable = false)
    private String companyDescription;

    @OneToMany
    private List<JobEntity> jobs;

    @OneToMany
    private List<ReviewEntity> reviewEntityList;

}
