package com.example.program.components;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

@Component
public class TextParser {

    public Map<String, Integer> findWords(Document document) {
        String text = Jsoup.clean(document.getAllElements().toString(), Whitelist.none());
        return counterToMap(text);
    }

    public Map<String, Integer> counterToMap(String text) {
        String newText = text.replaceAll("\\p{P}", "");
        String[] allWords = newText.toUpperCase().split(" ");
        Map<String, Integer> wordsMap = new HashMap<>();
        for (String word : allWords) {
            if (!wordsMap.containsKey(word)) {
                wordsMap.put(word, 1);
            } else {
                wordsMap.put(word, wordsMap.get(word) + 1);
            }
        }
        wordsMap.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed());
        return wordsMap;
    }
}
