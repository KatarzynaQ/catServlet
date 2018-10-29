package com.springcat.demo.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

public interface CatsRepository extends JpaRepository<Cat, Long> {

    Collection<Cat> findByColor(String findByColor);

}
