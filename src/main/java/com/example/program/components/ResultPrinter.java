package com.example.program.components;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

@Component
public class ResultPrinter {

    public void print(ArrayList<String> arrayList) {
        for (String line : arrayList) {
            System.out.println(line);
        }
    }
}
