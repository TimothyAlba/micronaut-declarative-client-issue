package com.timalba.micronaut.client;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;

@Controller("/server2")
public class Server2 {
    @Get(value = "/hello", processes = MediaType.TEXT_PLAIN)
    public String sayHello() {
        return "Hello from server2!";
    }
}
