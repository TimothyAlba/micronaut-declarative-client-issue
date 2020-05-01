package com.timalba.micronaut.client;

import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.MutableHttpResponse;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.server.netty.NettyHttpResponseFactory;
import io.reactivex.Maybe;

import javax.inject.Inject;

@Controller("/server1")
public class Server1 {
    @Inject
    BadClient badClient;
    @Inject
    GoodClient goodClient;

    @Get(value = "/bad-client", processes = MediaType.TEXT_PLAIN)
    public Maybe<MutableHttpResponse> badClient() {
        return badClient.getHello()
                .map(response -> {
                    if (response == null || response.isBlank())
                        return NettyHttpResponseFactory.INSTANCE.status(HttpStatus.NOT_FOUND, "Bad client couldn't get a hello from server 2 :(");
                    else
                        return NettyHttpResponseFactory.INSTANCE.ok(response);
                });
    }

    @Get(value = "/good-client", processes = MediaType.TEXT_PLAIN)
    public Maybe<MutableHttpResponse> goodClient() {
        return goodClient.getHello()
                .map(response -> {
                    if (response == null || response.isBlank())
                        return NettyHttpResponseFactory.INSTANCE.status(HttpStatus.NOT_FOUND, "Good client couldn't get a hello from server 2 :(");
                    else
                        return NettyHttpResponseFactory.INSTANCE.ok(response);
                });
    }
}
