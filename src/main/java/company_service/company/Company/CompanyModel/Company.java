package company_service.company.Company.CompanyModel;

import company_service.company.Job.Model.Job;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class Company {
    private Long id;
    private String companyName;
    private String location;
    private String companyDescription;
    private List<Job> JobModel;
}
