package com.example;

import com.example.repos.Room;
import com.example.service.CoronaDisinfector;

public class Main {
    public static void main(String[] args) {
        CoronaDisinfector disinfector = ObjectFactory.getInstance().createObject(CoronaDisinfector.class);

        disinfector.start(new Room());
    }
}
