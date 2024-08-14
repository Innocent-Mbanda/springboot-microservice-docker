package company_service.company.ServiceImpl;

import company_service.company.Company.Entity.CompanyEntity;
import company_service.company.Company.CompanyModel.Company;
import company_service.company.Company.Repo.CompanyRepo;
import company_service.company.Company.ServiceImpl.CompanyServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;


class CompanyServiceImpTest {
    @Mock
    private CompanyRepo companyRepo;

    @InjectMocks
    private CompanyServiceImp companyServiceImp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void addCompany_isSuccessfulTest() {
        //arrange
       Company company = Company.builder()
                .id(1L)
                .companyName("test")
                .location("test")
                .companyDescription("test")
                .build();
        //act
        companyServiceImp.addCompany(company);
        //assert
        verify(companyRepo,times(1)).save(any(CompanyEntity.class));
    }

    @Test
    void test_getAllCompanies_shouldReturnListOfCompanies() {
        CompanyEntity companyEntity1 = CompanyEntity.builder()

                .location("Location1")
                .companyName("Company1")
                .companyDescription("Description1")
                .build();
        CompanyEntity companyEntity2 = CompanyEntity.builder()
                .companyName("Company2")
                .location("Location2")
                .companyDescription("Description2")
                .build();
//        CompanyEntity companyEntity23= CompanyEntity.builder()
//                .companyName("Company2")
//                .location("Location2")
//                .companyDescription("Description2")
//                .build();

        List<CompanyEntity> companyEntities = new ArrayList<>(Arrays.asList(companyEntity1, companyEntity2));
        when(companyRepo.findAll()).thenReturn(companyEntities);

        // Act
        List<CompanyEntity> companies = companyServiceImp.getAllCompanies();

        // Assert
        assertEquals(2, companies.size());
        assertEquals("Company1", companies.get(0).getCompanyName());
        assertEquals("Location1", companies.get(0).getLocation());
        assertEquals("Description1", companies.get(0).getCompanyDescription());
        assertEquals("Company2", companies.get(1).getCompanyName());
        assertEquals("Location2", companies.get(1).getLocation());
        assertEquals("Description2", companies.get(1).getCompanyDescription());
    }


    @Test
    void getCompanyById() {
    }

    @Test
    void deleteCompanyById() {
    }

    @Test
    void updateCompany() {
    }

    @Test
    void deleteCompany() {
    }

    @Test
    void builder() {
    }
}