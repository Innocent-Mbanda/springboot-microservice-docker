package company_service.company.Job.Entity;

import company_service.company.Company.CompanyModel.Company;
import company_service.company.Company.Entity.CompanyEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table( name = "job_table")

public class JobEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String title;
    private String jobDescription;
    private String minSalary;
    private String maxSalary;
    private String location;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private CompanyEntity company;;

//
//    public Job(String location, Long id, String title, String jobDescription, String minSalary, String maxSalary) {
//        this.location = location;
//        Id = id;
//        this.title = title;
//        this.jobDescription = jobDescription;
//        this.minSalary = minSalary;
//        this.maxSalary = maxSalary;
//    }
//
//    public Long getId() {
//        return Id;
//    }
//
//    public void setId(Long id) {
//        Id = id;
//    }
//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//    public String getMaxSalary() {
//        return maxSalary;
//    }
//
//    public void setMaxSalary(String maxSalary) {
//        this.maxSalary = maxSalary;
//    }
//
//    public String getMinSalary() {
//        return minSalary;
//    }
//
//    public void setMinSalary(String minSalary) {
//        this.minSalary = minSalary;
//    }
//
//    public String getJobDescription() {
//        return jobDescription;
//    }
//
//    public void setJobDescription(String jobDescription) {
//        this.jobDescription = jobDescription;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
}
