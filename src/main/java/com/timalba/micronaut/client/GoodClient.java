package com.timalba.micronaut.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Maybe;

@Client("http://localhost:8080/server2")
public interface GoodClient {
    @Get("/hello")
    Maybe<String> getHello();
}
