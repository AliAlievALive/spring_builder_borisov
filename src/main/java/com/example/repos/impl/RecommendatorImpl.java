package com.example.repos.impl;

public class RecommendatorImpl implements Recommendator {
    @InjectProperty("tea")
    private String medicine;

    @Override
    public void recommend() {
        System.out.println("to protect from covid, drink " + medicine);
    }
}
