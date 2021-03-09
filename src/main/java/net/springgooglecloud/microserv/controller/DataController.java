package net.springgooglecloud.microserv.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.springgooglecloud.microserv.entity.DataEntity;
import net.springgooglecloud.microserv.repository.DataRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DataController {

    @Value("${db.data}}")
    String message;

    private final DataRepository dataRepository;

    @GetMapping("/data")
    ResponseEntity<String> getData() {
        log.info("Retrieving data");
        DataEntity entity = dataRepository.findAll().get(0);
        return ResponseEntity.ok(entity.getValue());
    }
}

