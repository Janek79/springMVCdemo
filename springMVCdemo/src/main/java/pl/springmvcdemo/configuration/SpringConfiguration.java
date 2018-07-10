package pl.springmvcdemo.configuration;

import java.beans.PropertyVetoException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan("pl.springmvcdemo")
@EnableTransactionManagement
public class SpringConfiguration {
	@Bean
	public ViewResolver getViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		
		return viewResolver;
	}
	
	@Bean
	public ComboPooledDataSource getComboPooledDataSource() {
		String url = "jdbc:mysql://db4free.net/sql5vlp5dhq78?useSSL=false";
		String user = "sqlfbatpp0u82";
		String password = "hiberjava";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		ComboPooledDataSource dataSource = new ComboPooledDataSource();
		
		dataSource.setJdbcUrl(url);
		dataSource.setUser(user);
		dataSource.setPassword(password);
		try {
			dataSource.setDriverClass(driver);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		
		dataSource.setInitialPoolSize(3);
		dataSource.setMaxPoolSize(20);
		dataSource.setMaxIdleTime(30000);
		
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean getSessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		Properties hibernateProperties = sessionFactory.getHibernateProperties();
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLInnoDBDialect");
		
		sessionFactory.setDataSource(getComboPooledDataSource());
		sessionFactory.setPackagesToScan("pl.springmvcdemo.entity");
		sessionFactory.setHibernateProperties(hibernateProperties);
		
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		return new HibernateTransactionManager(sessionFactory);
	}
}
