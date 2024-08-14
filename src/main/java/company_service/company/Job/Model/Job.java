package company_service.company.Job.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Job {
    private Long Id;
    private String title;
    private String jobDescription;
    private String minSalary;
    private String maxSalary;
    private String location;

}
