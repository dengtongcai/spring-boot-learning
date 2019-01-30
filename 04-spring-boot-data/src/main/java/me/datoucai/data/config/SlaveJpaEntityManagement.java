package me.datoucai.data.config;

import me.datoucai.data.jpa.slave.SlaveMultipartUserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

/**
 * @author cc
 * @date 2019/1/30
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        basePackageClasses = {SlaveMultipartUserRepository.class},
        entityManagerFactoryRef = "slaveEntityManagerFactory",
        transactionManagerRef = "slaveTransactionManager")
public class SlaveJpaEntityManagement {

    private JpaProperties jpaProperties;

    private DataSource slaveDataSource;

    public SlaveJpaEntityManagement(JpaProperties jpaProperties, @Qualifier("slaveDataSource") DataSource slaveDataSource) {
        this.jpaProperties = jpaProperties;
        this.slaveDataSource = slaveDataSource;
    }

    @Bean(name = "slaveEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryBean(builder).getObject().createEntityManager();
    }

    @Bean(name = "slaveEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(slaveDataSource)
                .properties(jpaProperties.getProperties())
                .packages("me.datoucai.data.vo")
                .persistenceUnit("slavePersistenceUnit")
                .build();
    }

    @Bean(name = "slaveTransactionManager")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryBean(builder).getObject());
    }
}