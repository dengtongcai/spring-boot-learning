package me.datoucai.sharding.api;

import me.datoucai.sharding.repository.CompanyRepository;
import me.datoucai.sharding.vo.Company;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cc
 * @date 2019/2/18
 */
@RestController
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PostMapping(value = "/add")
    public Company addInfo(Company company){
        return companyRepository.save(company);
    }

}
