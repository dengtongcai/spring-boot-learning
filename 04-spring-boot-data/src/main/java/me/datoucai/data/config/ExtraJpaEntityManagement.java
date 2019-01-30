package me.datoucai.data.config;

import me.datoucai.data.jpa.extra.ExtraMultipartUserRepository;
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
        basePackageClasses = {ExtraMultipartUserRepository.class},
        entityManagerFactoryRef = "extraEntityManagerFactory",
        transactionManagerRef = "extraTransactionManager")
public class ExtraJpaEntityManagement {

    private JpaProperties jpaProperties;

    private DataSource extraDataSource;

    public ExtraJpaEntityManagement(JpaProperties jpaProperties, @Qualifier("extraDataSource") DataSource extraDataSource) {
        this.jpaProperties = jpaProperties;
        this.extraDataSource = extraDataSource;
    }

    @Bean(name = "extraEntityManager")
    public EntityManager entityManager(EntityManagerFactoryBuilder builder) {
        return entityManagerFactoryBean(builder).getObject().createEntityManager();
    }

    @Bean(name = "extraEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder) {
        return builder.dataSource(extraDataSource)
                .properties(jpaProperties.getProperties())
                .packages("me.datoucai.data.vo")
                .persistenceUnit("extraPersistenceUnit")
                .build();
    }

    @Bean(name = "extraTransactionManager")
    public PlatformTransactionManager transactionManagerPrimary(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactoryBean(builder).getObject());
    }
}