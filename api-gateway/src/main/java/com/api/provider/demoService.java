package com.api.provider;

import java.util.concurrent.CompletableFuture;

public interface demoService {
    String sayHello(String name);

    String sayHello2(String name);

    default CompletableFuture<String> sayHelloAsync(String name) {
        return CompletableFuture.completedFuture(sayHello(name));
    }
}
