package com.example.repos.impl;

@Singleton
public class RecommendatorImpl implements Recommendator {
    @InjectProperty("tea")
    private String medicine;

    public RecommendatorImpl() {
        System.out.println("Recommendator was created");
    }

    @Override
    public void recommend() {
        System.out.println("to protect from covid, drink " + medicine);
    }
}
