package com.example.program.components;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.safety.Whitelist;
import org.springframework.stereotype.Component;

@Component
public class TextParser {

    public String findWords(Document document) {

        return Jsoup.clean(document.getAllElements().toString(), Whitelist.none());
    }
}
