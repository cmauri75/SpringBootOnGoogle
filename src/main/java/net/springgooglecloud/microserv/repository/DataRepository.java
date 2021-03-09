package net.springgooglecloud.microserv.repository;

import net.springgooglecloud.microserv.entity.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DataRepository extends JpaRepository<DataEntity, Long> {
}

