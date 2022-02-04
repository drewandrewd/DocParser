package com.example.program.exceptions;

import java.net.MalformedURLException;

public class SiteNotFoundException extends Exception {
    public SiteNotFoundException(String WrongUrl) {
        super(WrongUrl);
    }
}
