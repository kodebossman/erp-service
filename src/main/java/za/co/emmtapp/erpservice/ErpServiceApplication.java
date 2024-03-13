package za.co.emmtapp.erpservice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@OpenAPIDefinition(
		info = @Info(
				title = "ERP Service APIs Documentation",
				description = "REST APIs for ERP Service",
				version = "v1",
				contact = @Contact(
						name = "Marlone Nyapwere",
						email = "marlonenyapwere@gmail.com"
				),
				license = @License(
						name = "License Information",
						url = "https://www.marlone.com"
				)
		)
)
public class ErpServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(ErpServiceApplication.class, args);
		log.info("EMMTAPP_ERP_SERVICE STARTED SUCCESSFULLY !!!");

	}

}
