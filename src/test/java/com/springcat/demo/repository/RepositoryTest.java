package com.springcat.demo.repository;

import com.springcat.demo.model.Cat;
import com.springcat.demo.model.CatsRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringJUnitConfig
@SpringBootTest
@DirtiesContext(methodMode = DirtiesContext.MethodMode.BEFORE_METHOD)
public class RepositoryTest {

    @Autowired
    private CatsRepository catsRepository;

    @DisplayName("should save example Cat into repository")
    @Test
    void test() throws Exception {
        // given
        Cat catGoobar = new Cat("Goobar", "red", 1);

        // when
        catsRepository.save(catGoobar);

        // then
        List<Cat> all = catsRepository.findAll();
        assertThat(all).hasSize(1);
    }

}
