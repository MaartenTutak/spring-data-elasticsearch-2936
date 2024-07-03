package com.example.demo;

import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;
import java.util.UUID;

public interface FooRepository extends ElasticsearchRepository<Foo, UUID> {

    @Query("""
            {
                "bool": {
                    "must": [
                        {
                            "match": {
                                "type": "?0"
                            }
                        },
                        {
                            "match": {
                                "source": "?1"
                            }
                        }
                    ]
                }
            }
            """)
    List<Foo> findBy(String type, String source);
}
