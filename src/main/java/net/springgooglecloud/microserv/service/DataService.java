package net.springgooglecloud.microserv.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.springgooglecloud.microserv.entity.DataEntity;
import net.springgooglecloud.microserv.repository.DataRepository;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class DataService {

    private final DataRepository dataRepository;

    public DataEntity getData() {
        log.info("Retrieving data in service");
        DataEntity entity = dataRepository.findAll().get(0);
        return entity;
    }
}

