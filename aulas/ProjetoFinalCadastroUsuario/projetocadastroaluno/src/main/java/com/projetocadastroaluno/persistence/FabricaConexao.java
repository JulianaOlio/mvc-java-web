package com.projetocadastroaluno.persistence;

import javax.sql.DataSource;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;


@Configuration
public class FabricaConexao {
	
	
	// metodo que busca o banco de dados
	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSourceCriado = new DriverManagerDataSource();
		dataSourceCriado.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSourceCriado.setUrl("jdbc:mysql://localhost:3306/db_cadastroaluno");
		dataSourceCriado.setUsername("root");
		dataSourceCriado.setPassword("ROOT");

		return dataSourceCriado;

	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.MYSQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true); 
		adapter.setDatabasePlatform("org.hibernate.dialect.MySQLDialect");
		adapter.setPrepareConnection(true);
		
		return adapter;
	}

}
