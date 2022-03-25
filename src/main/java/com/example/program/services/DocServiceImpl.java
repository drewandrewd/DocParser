package com.example.program.services;

import com.example.program.components.DocParser;
import com.example.program.components.LineReader;
import com.example.program.components.ResultPrinter;
import com.example.program.exceptions.SiteNotFoundException;
import com.example.program.models.Doc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Slf4j
@Service
public class DocServiceImpl implements DocService {

    private DocParser parser;
    private ResultPrinter printer;
    private Doc doc;
    private LineReader lineReader;


    @Override
    public void parse() throws IOException, SiteNotFoundException {
        printer.print(parser.findWords(doc, lineReader.readLine()));
    }

    @Autowired
    public void setParser(DocParser parser) {
        this.parser = parser;
    }

    @Autowired
    public void setPrinter(ResultPrinter printer) {
        this.printer = printer;
    }

    @Autowired
    public void setDoc(Doc doc) {
        this.doc = doc;
    }

    @Autowired
    public void setLineReader(LineReader lineReader) {
        this.lineReader = lineReader;
    }
}
