package com.java.practice.lang.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * java.net.http 在java11开始支持
 */
class HttpTests {

    @Test
    @DisplayName("同步http请求")
    void testSyncGet() throws IOException, InterruptedException {
        // 组建 request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://openjdk.java.net/"))
                .timeout(Duration.ofMillis(5009))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request,HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }

    @Test
    @DisplayName("同步http请求，抛出异常")
    void testSyncGetThrow() throws IOException, InterruptedException {
        try{
            // 组建 request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://openjdk.java.net/"))
                    .timeout(Duration.ofMillis(1))
                    .build();
            HttpClient httpClient = HttpClient.newHttpClient();
            httpClient.send(request,HttpResponse.BodyHandlers.ofString());
        }catch (HttpConnectTimeoutException e){
            System.out.println("HTTP connect timed out");
        }
        try{
            // 组建 request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://openjdk.java.net/"))
                    .timeout(Duration.ofMillis(10000))
                    .build();
            HttpClient httpClient = HttpClient.newBuilder().connectTimeout(Duration.ofMillis(1)).build();
            httpClient.send(request,HttpResponse.BodyHandlers.ofString());
        }catch (HttpConnectTimeoutException e){
            System.out.println("HTTP connect timed out");
        }
    }

    @Test
    @DisplayName("异步http请求")
    void testAsyncGet() throws IOException, InterruptedException, ExecutionException {
        // 组建 request
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://openjdk.java.net/"))
                .timeout(Duration.ofMillis(5009))
                .build();
        HttpClient httpClient = HttpClient.newHttpClient();
        CompletableFuture future  = httpClient.sendAsync(request,HttpResponse.BodyHandlers.ofString());
        while (!future.isDone());
        HttpResponse httpResponse = (HttpResponse) future.get();
        System.out.println(httpClient.version());
        System.out.println(String.format("返回body长度为：%s",httpResponse.body().toString().length()));
    }

}
