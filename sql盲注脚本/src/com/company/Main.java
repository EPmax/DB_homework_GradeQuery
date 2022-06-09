package com.company;

import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class Main {

    public static void main(String[] args) throws Exception {
        Init2 init[] = new Init2[20];
        for(int i=0;i<20;i++){
            init[i]=new Init2(i);
        }
        for(int i=0;i<3;i++){
            init[i++].start();
            init[i].init();
        }
    }
}