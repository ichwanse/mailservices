package id.co.jasindo.mailservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableJpaAuditing
@EnableSwagger2
@SpringBootApplication
public class MailservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MailservicesApplication.class, args);
	}

}
