package com.example.program.services;

import com.example.program.components.SiteParser;
import com.example.program.components.UrlReader;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SiteServiceImpl implements SiteService {

    private SiteParser siteParser;
    private UrlReader urlReader;

    @Override
    public void create() throws IOException {
        String url = urlReader.readUrl();
        Document fullSite = siteParser.getDocument(url);
    }

    @Autowired
    public void setSiteParser(SiteParser siteParser) {
        this.siteParser = siteParser;
    }

    @Autowired
    public void setUrlReader(UrlReader urlReader) {
        this.urlReader = urlReader;
    }
}
