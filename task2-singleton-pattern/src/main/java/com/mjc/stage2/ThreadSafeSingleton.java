package com.mjc.stage2;

public class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;
    private ThreadSafeSingleton() {};

    private static synchronized ThreadSafeSingleton getInstance() {
        if (instance != null) {
            return instance;
        } else {
            instance = new ThreadSafeSingleton();
        }
        return instance;

    }
}
