package me.datoucai.data.jpa.slave;

import me.datoucai.data.vo.MultipartUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author cc
 * @date 2019/1/30
 */
public interface SlaveMultipartUserRepository extends JpaRepository<MultipartUser, Integer> {

}
