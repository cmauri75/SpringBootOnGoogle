package net.springgooglecloud.microserv;

import lombok.extern.slf4j.Slf4j;
import net.springgooglecloud.microserv.repository.DataRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class MicroservApplicationTests {

    @Test
    void contextLoads() {
    }

    @Value("${db.data}")
    String message;

    @Autowired
    private DataRepository dataRepository;

    @Test
    void testInsert() {
        log.info("Checking {}",message);
        Assertions.assertEquals(message, dataRepository.findAll().get(0).getValue());
    }
}
