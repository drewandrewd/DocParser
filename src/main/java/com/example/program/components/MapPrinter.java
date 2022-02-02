package com.example.program.components;

import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Map;

@Component
public class MapPrinter {

    public void printMap(Map<String, Integer> map) {
        for (Map.Entry<String, Integer> curr : map.entrySet()) {
            System.out.println(curr.getKey() + " - " + curr.getValue());
        }
    }
}
