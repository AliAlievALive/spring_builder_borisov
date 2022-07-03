package com.example.repos.impl;

import com.example.repos.Policeman;
import com.example.service.InjectByType;

import javax.annotation.PostConstruct;

public class PolicemanImpl implements Policeman {

    @InjectByType
    private RecommendatorImpl recommendator;

    @PostConstruct
    public void init() {
        System.out.println(recommendator.getClass());
    }

    @Override
    public void makePeopleLeaveRoom() {
        System.out.println("Вооон!!!");
    }
}
