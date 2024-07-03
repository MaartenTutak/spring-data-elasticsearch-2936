package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.elasticsearch.DataElasticsearchTest;
import org.springframework.context.annotation.Import;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataElasticsearchTest
@Import(TestcontainersConfiguration.class)
class FooRepositoryIntegrationTest {

    @Autowired
    private FooRepository fooRepository;

    @BeforeEach
    void setUp() {
        fooRepository.save(new Foo(UUID.randomUUID(), "Foo", "Bar"));
    }

    @Test
    void givenNull_whenFindByName_ThenReturnEmptyList() {
        assertThat(fooRepository.findBy("Foo", null)).isEmpty();
    }
}
