package com.example.program.components;

import com.example.program.models.Doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.*;
import java.util.*;

@Component
public class DocParser {

    public ArrayList<String> findWords(Doc document, String line) throws IOException {
        FileReader file = new  FileReader(document.getName());
        BufferedReader reader = new BufferedReader(file);
        String fileLine = reader.readLine();
        ArrayList<String> arrayList = new ArrayList<>();
        while (fileLine != null) {
            String[] columns = fileLine.split(",");
            if (checkWord(columns[document.getColumn()], line)) {
                arrayList.add(fileLine);
            }
            fileLine = reader.readLine();
        }
        Collections.sort(arrayList);
        return arrayList;
    }

    public boolean checkWord(String text, String line) {
        boolean result = false;
        if (text.contains(line)) {
            result = true;
        }
        return result;
    }
}
