package company_service.company.Company.Service;

import company_service.company.Company.Entity.CompanyEntity;
import company_service.company.Company.CompanyModel.Company;

import java.util.List;


public interface CompanyService {
    void addCompany(Company company);
   List<CompanyEntity> getAllCompanies();
    CompanyEntity getCompanyById(Long id);
    void deleteCompanyById(Long id);
   boolean updateCompany(Long id, Company company);
}

