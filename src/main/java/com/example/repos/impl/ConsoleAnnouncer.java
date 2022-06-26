package com.example.repos.impl;

import com.example.repos.Announcer;

public class ConsoleAnnouncer implements Announcer {
    @Override
    public void announce(String message) {
        System.out.println(message);
    }
}
