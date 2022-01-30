package com.example.program.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Map;

@Data
@Document(collection = "models")
public class Site {

    @Id
    private String id;

    private String name;
    private Map<String, Integer> words;
}
