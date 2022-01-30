package com.example.program.repositories;

import com.example.program.models.Site;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SiteRepository extends MongoRepository<Site, String> {
    List<Site> findByName(String name);
}
