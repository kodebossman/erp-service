package za.co.emmtapp.erpservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ErpServiceApplication {

	public static void main(String[] args) {

		SpringApplication.run(ErpServiceApplication.class, args);
		log.info("EMMTAPP_ERP_SERVICE STARTED SUCCESSFULLY !!!");

	}

}
