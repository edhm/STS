package com.example.ReadingFace.Beans;

import org.springframework.context.annotation.Bean;
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
	 * @Bean(name = "beanConexionDos")
	public Conexion conexion() {
		Conexion conexion = new Conexion();
		conexion.setDb("mysql");
		conexion.setUrl("localhost");
		return conexion;
	}
	 * */
}
