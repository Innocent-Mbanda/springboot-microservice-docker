package company_service.company.Company.Controller;

import company_service.company.Company.Entity.CompanyEntity;
import company_service.company.Company.ServiceImpl.CompanyServiceImp;
import company_service.company.Company.CompanyModel.Company;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class CompanyController {
    @Autowired
    private CompanyServiceImp companyServiceImp;

    @PostMapping("/add")
    public ResponseEntity<String> AddCompany(@RequestBody Company company) {
        companyServiceImp.addCompany(company);
        return ResponseEntity.ok("Company Added");

    }

    @GetMapping("/companies")
    public ResponseEntity<List<CompanyEntity>> findAllCompanies() {
        return ResponseEntity.ok(companyServiceImp.getAllCompanies());
    }

    @GetMapping("/companies/{id}")
    public ResponseEntity<CompanyEntity> getCompanyById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(companyServiceImp.getCompanyById(id));
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }
    @PutMapping("/companies/{id}")
    public ResponseEntity<String> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        try {
            companyServiceImp.updateCompany(id, company);
            return ResponseEntity.ok("Company Updated");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
    @DeleteMapping("/companies/{id}")
    public ResponseEntity<String> deleteCompanyById(@PathVariable Long id) {
        try {
            companyServiceImp.deleteCompanyById(id);
            return ResponseEntity.ok("Company Deleted");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }

    }
}
