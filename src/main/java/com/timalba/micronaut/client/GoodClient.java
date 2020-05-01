package com.timalba.micronaut.client;

import io.micronaut.http.annotation.Get;
import io.micronaut.http.client.annotation.Client;
import io.reactivex.Maybe;

@Client("good-client")
public interface GoodClient {
    @Get("/server2/hello")
    Maybe<String> getHello();
}
