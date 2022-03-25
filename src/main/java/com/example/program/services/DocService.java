package com.example.program.services;

import com.example.program.exceptions.SiteNotFoundException;

import java.io.IOException;

public interface DocService {

    void parse() throws IOException, SiteNotFoundException;
}
