package company_service.company.Job.company;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Company {
    private Long id;
    private String companyName;
    private String location;
    private String companyDescription;

}
