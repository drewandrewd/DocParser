package com.example.program.components;

import com.example.program.exceptions.SiteNotFoundException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class SiteParser {

    public Document getDocument(String url) throws SiteNotFoundException {
        Document document = new Document("");
        try {
            document = Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:96.0) Gecko/20100101 Firefox/96.0").referrer("http://www.google.com").get();

        } catch (Exception e) {
            throw new SiteNotFoundException("Wrong url: " + url);
        }
        return document;
    }
}
