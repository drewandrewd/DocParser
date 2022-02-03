package com.example.program.services;

import com.example.program.components.MapPrinter;
import com.example.program.components.SiteParser;
import com.example.program.components.TextParser;
import com.example.program.components.UrlReader;
import com.example.program.models.Site;
import com.example.program.repositories.SiteRepository;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Map;

@Service
public class SiteServiceImpl implements SiteService {

    private SiteParser siteParser;
    private UrlReader urlReader;
    private TextParser textParser;
    private MapPrinter mapPrinter;
    private SiteRepository repository;

    @Override
    public void create() throws IOException {
        String url = urlReader.readUrl();
        Document fullSite = siteParser.getDocument(url);
        Map<String, Integer> map = textParser.findWords(fullSite);
        Site site = new Site();
        site.setName(url);
        site.setWords(map);
        repository.save(site);
        mapPrinter.printMap(map);
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

    @Autowired
    public void setMapPrinter(MapPrinter mapPrinter) {
        this.mapPrinter = mapPrinter;
    }

    @Autowired
    public void setRepository(SiteRepository repository) {
        this.repository = repository;
    }
}
