package com.timalba.micronaut.client;

import io.micronaut.runtime.Micronaut;

public class Application {
    public static void main(String[] args) {
        System.out.println("We are in the program!");
        Micronaut.run(Application.class,args);
        System.out.println("We are leaving!");
    }
}
