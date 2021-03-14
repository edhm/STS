package com.example.ReadingFace;

import org.apache.commons.logging.LogFactory;

import java.io.BufferedReader;
import java.nio.Buffer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import com.example.ReadingFace.Components.PostComponent;
import com.example.ReadingFace.Model.Conexion;
import com.example.ReadingFace.Services.PostService;

@SpringBootApplication
public class ReadingFaceApplication implements CommandLineRunner {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Value("${readingFace.jdbc.import.ruta}")
	private String ruta;

	@Value("${readingFace.jdbc.import}")
	private String importar;

	public ReadingFaceApplication() {
	}

	Log log = LogFactory.getLog(getClass());

	public static void main(String[] args) {
		SpringApplication.run(ReadingFaceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (importar.equalsIgnoreCase("true")) {
			// Path path = Paths.get("src/main/resources/import_querys.sql");
			Path path = Paths.get(ruta);

			try (BufferedReader bufferedReader = Files.newBufferedReader(path, Charset.forName("UTF-8"))) {
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					jdbcTemplate.execute(line);
					// jdbcTemplate.execute("INSERT into permiso (nombre) values ('.Net
					// Architect')");
					log.info(line);
				}
			} catch (Exception e) {

			}

		}
		log.info("Cantidad de permisos: "
				+ jdbcTemplate.queryForObject("SELECT COUNT(*) FROM blog.permiso;", Integer.class));
	}

}
