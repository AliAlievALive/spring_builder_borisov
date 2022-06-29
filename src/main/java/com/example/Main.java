package com.example;

import com.example.repos.Policeman;
import com.example.repos.Room;
import com.example.repos.impl.PolicemanImpl;
import com.example.service.CoronaDisinfector;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        CoronaDisinfector disinfector = ObjectFactory.getInstance().createObject(CoronaDisinfector.class);
        ApplicationContext context = Application.run("com.example", new HashMap<>(Map.of(Policeman.class, PolicemanImpl.class)));
        CoronaDisinfector disinfector = context.getObject(CoronaDisinfector.class);
        disinfector.start(new Room());
    }
}
