package com.servicedto.techiteasy.repositories;

import com.servicedto.techiteasy.models.Television;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TelevisionRepository extends JpaRepository<Television, Long> {

    List<Television> findByIdIs(Long id);

}
