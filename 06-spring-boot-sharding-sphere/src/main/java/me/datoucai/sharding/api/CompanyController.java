package me.datoucai.sharding.api;

import me.datoucai.sharding.repository.CompanyRepository;
import me.datoucai.sharding.vo.Company;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * @author cc
 * @date 2019/2/18
 */
@RestController
@RequestMapping(value = "/sharding")
public class CompanyController {

    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @PostMapping(value = "/add")
    public Company addInfo(@RequestBody Company company){
        return companyRepository.save(company);
    }

    @GetMapping(value = "/infos")
    public Collection<Company> getInfos(){
        return companyRepository.findAll();
    }
}
