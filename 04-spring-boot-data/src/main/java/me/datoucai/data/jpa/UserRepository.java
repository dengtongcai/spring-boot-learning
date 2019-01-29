package me.datoucai.data.jpa;

import me.datoucai.data.vo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author cc
 * @date 2019/1/29
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByName(String name);

    @Query("FROM User WHERE age=:age")
    List<User> findByHql(@Param("age") Integer age);

    @Query(value = "SELECT * FROM user WHERE name=?1 AND age=?2", nativeQuery = true)
    List<User> findBySql(String name, Integer age);
}
