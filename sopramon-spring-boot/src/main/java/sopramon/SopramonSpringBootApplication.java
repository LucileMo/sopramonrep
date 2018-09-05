package sopramon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"sopramon" })
@EnableJpaRepositories("dao")
@EntityScan("sopramon.model")
public class SopramonSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SopramonSpringBootApplication.class, args);

	}
	
}

