package net.springgooglecloud.microserv.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.springgooglecloud.microserv.entity.DataEntity;
import net.springgooglecloud.microserv.service.DataService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class DataController {

    private final DataService dataService;

    @GetMapping("/data")
    ResponseEntity<String> getData() {
        log.info("Retrieving data from service");
        DataEntity entity = dataService.getData();
        return ResponseEntity.ok(entity.getValue());
    }
}

