package com.example.repos.impl;

import com.example.ObjectFactory;
import com.example.repos.Announcer;

public class ConsoleAnnouncer implements Announcer {
    private final Recommendator recommendator = ObjectFactory.getInstance().createObject(Recommendator.class);
    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
