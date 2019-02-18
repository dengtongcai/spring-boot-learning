package me.datoucai.sharding.repository;

import me.datoucai.sharding.vo.Company;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cc
 * @date 2019/2/18
 */
public interface CompanyRepository extends JpaRepository<Company, Long> {

}
