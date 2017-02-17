package com.ehealth.doctors.config;

import com.ehealth.doctors.dao.IDoctorDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;

;

@Configuration
@ComponentScan(basePackages = {"com.ehealth.doctors"}, excludeFilters = @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = SpringWebConfig.class))
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.ehealth.doctors.dao")
@PropertySource("classpath:config.properties")
public class AppConfiguration {

    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${user.db}")
    private String userdb;
    @Value("${password.db}")
    private String passworddb;

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory()
            throws ClassNotFoundException, PropertyVetoException {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setDataSource(dataSource());
        emf.setPackagesToScan("com.ehealth.doctors.model");
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        emf.setJpaVendorAdapter(vendorAdapter);
        emf.setJpaProperties(additionalProperties());
        return emf;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(userdb);
        dataSource.setPassword(passworddb);
        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);

        return transactionManager;
    }

    Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");
        properties.setProperty("show_sql", "true");
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        return properties;
    }
}
