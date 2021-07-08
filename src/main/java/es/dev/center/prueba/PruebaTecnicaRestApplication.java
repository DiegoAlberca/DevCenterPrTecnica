package es.dev.center.prueba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"es.dev.center.prueba"})
public class PruebaTecnicaRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaTecnicaRestApplication.class, args);
	}

}
