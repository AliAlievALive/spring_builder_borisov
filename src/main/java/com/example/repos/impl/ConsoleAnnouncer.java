package com.example.repos.impl;

import com.example.repos.Announcer;
import com.example.service.InjectByType;

public class ConsoleAnnouncer implements Announcer {
    @InjectByType
    private Recommendator recommendator;
    @Override
    public void announce(String message) {
        System.out.println(message);
        recommendator.recommend();
    }
}
