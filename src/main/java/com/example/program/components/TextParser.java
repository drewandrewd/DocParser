package com.example.program.components;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class TextParser {

    public Map<String, Integer> findWords(Document document) {
        String text = Jsoup.parse(document.text()).text();
        return counterToMap(text);
    }

    public Map<String, Integer> counterToMap(String text) {
        String newText = text.replaceAll("\\p{P}", "");
        String[] allWords = newText.toUpperCase().split(" ");
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : allWords) {
            if (word.equals("")) {
                continue;
            } else if (!wordsMap.containsKey(word)) {
                wordsMap.put(word, 1);
            } else {
                wordsMap.put(word, wordsMap.get(word) + 1);
            }
        }
        return wordsMap.entrySet()
                .stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new));
    }
}
