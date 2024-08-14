package company_service.company.Company.ServiceImpl;

import company_service.company.Company.Service.CompanyService;
import company_service.company.Company.Entity.CompanyEntity;
import company_service.company.Company.CompanyModel.Company;
import company_service.company.Company.Repo.CompanyRepo;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Builder
public class CompanyServiceImp implements CompanyService {
    private CompanyRepo companyRepo;

    public CompanyServiceImp(CompanyRepo companyRepo) {
        this.companyRepo = companyRepo;
    }
    @Override
    public void addCompany(Company company) {
        CompanyEntity companyEntity = CompanyEntity.builder()
                .companyName(company.getCompanyName())
                .location(company.getLocation())
                .companyDescription(company.getCompanyDescription())
                .build();
        companyRepo.save(companyEntity);
    }
    @Override
    public List<CompanyEntity> getAllCompanies() {
       return companyRepo.findAll();
    }
    @Override
    public CompanyEntity getCompanyById(Long id) {
    if (companyRepo.findById(id).isPresent()){
        return companyRepo.findById(id).get();
    }
        return null;
    }

    /**
     * @param id
     */
    @Override
    public void deleteCompanyById(Long id) {
        if (companyRepo.findById((id)).isPresent()){
            companyRepo.deleteById(id);
        }
        else {
            throw new RuntimeException("Company not found");
        }

    }

    @Override
    public boolean updateCompany(Long id, Company company) {
        Optional<CompanyEntity> companyToUpdate = companyRepo.findById(id);
        if (companyToUpdate.isPresent()){
            CompanyEntity companyEntity = companyToUpdate.get();
            companyEntity.setCompanyName(company.getCompanyName());
            companyEntity.setLocation(company.getLocation());
            companyEntity.setCompanyDescription(company.getCompanyDescription());
            companyRepo.save(companyEntity);
            return true;
        }
        return false;
    }

}
