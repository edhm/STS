package com.example.ReadingFace.Beans;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import com.example.ReadingFace.Model.Conexion;
import com.example.ReadingFace.Model.Usuario;

@Component
public class CreandoConexion {

	@Bean(name = "beanUsuario")
	public Usuario getUsuario() {
		return new Usuario();
	}

	@Bean(name = "beanConexion")
	public Conexion getConexion() {
		Conexion conexion = new Conexion();
		conexion.setDb("mysql");
		conexion.setUrl("localhost");
		return conexion;
	}

	/*
	 * @Bean(name = "beanConexionDos") public Conexion conexion() { Conexion
	 * conexion = new Conexion(); conexion.setDb("mysql");
	 * conexion.setUrl("localhost"); return conexion; }
	 */

	@Bean
	public DataSource getDatasource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/blog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC");
		/*
?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC
		 * */
		/*
		 * ds.setUsername("guest_user"); ds.setPassword("guest_password");
		 **/
		ds.setUsername("wenly");
		ds.setPassword("whm");

		return ds;
	}
}
