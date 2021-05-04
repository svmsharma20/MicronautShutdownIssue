package com.example;

import io.micronaut.context.annotation.Context;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Singleton;

@Context
@Singleton
public class AppLifeCycle {

    @PostConstruct
    void onStartup(){
        System.out.println("***************** On Startup *****************");
        Thread thread1 = new Thread( () -> {
            try {
                Thread.sleep(60000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread processing completed");
        });
        thread1.setDaemon(false);
        thread1.start();
    }

    @PreDestroy
    void onShutdown(){
        System.out.println("***************** On Shutdown *****************" );
    }

}
