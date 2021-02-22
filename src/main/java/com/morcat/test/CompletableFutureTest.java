package com.morcat.test;

import java.util.concurrent.CompletableFuture;

/**
 *
 *  @author shenzixing
 *  @since 2021-02-18
 */
public class CompletableFutureTest {

    public static void main(String[] args) throws Exception {
        CompletableFuture futureA = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(1000L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return -100;
        });
        futureA.thenAccept(System.out::println);


        Thread.sleep(3000L);

    }
}
