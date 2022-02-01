package com.example.program.services;

import com.example.program.components.SiteParser;
import com.example.program.components.TextParser;
import com.example.program.components.UrlReader;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class SiteServiceImpl implements SiteService {

    private SiteParser siteParser;
    private UrlReader urlReader;
    private TextParser textParser;
//    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));


    @Override
    public String create() throws IOException {
        String url = urlReader.readUrl();
        Document fullSite = siteParser.getDocument(url);
        return textParser.findWords(fullSite);
    }

    @Autowired
    public void setUrlReader(UrlReader urlReader) {
        this.urlReader = urlReader;
    }

    @Autowired
    public void setSiteParser(SiteParser siteParser) {
        this.siteParser = siteParser;
    }

    @Autowired
    public void setTextParser(TextParser textParser) {
        this.textParser = textParser;
    }
}
