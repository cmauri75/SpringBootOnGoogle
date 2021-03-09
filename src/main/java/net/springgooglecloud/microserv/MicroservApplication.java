package net.springgooglecloud.microserv;

import net.springgooglecloud.microserv.entity.DataEntity;
import net.springgooglecloud.microserv.repository.DataRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroservApplication {

	@Value("${db.data}")
	String dbData;

	public static void main(String[] args) {
		SpringApplication.run(MicroservApplication.class, args);
	}

	/**
	 * Saves data in DB just for demo purpose
	 */
	@Bean
	CommandLineRunner runner(DataRepository dataRepository) {
		return args -> {
			DataEntity entity = new DataEntity();
			entity.setValue(dbData);
			dataRepository.save(entity);
		};
	}


}
