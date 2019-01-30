package me.datoucai.data.jpa.master;

import me.datoucai.data.vo.MultipartUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cc
 * @date 2019/1/30
 */
public interface MasterMultipartUserRepository extends JpaRepository<MultipartUser, Integer> {

}
