package com.timalba.micronaut.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Maybe;

@Client("bad-client")
public interface BadClient {
    @Get("/hello")
    Maybe<String> getHello();
}
