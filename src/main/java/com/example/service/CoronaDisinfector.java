package com.example.service;

import com.example.ObjectFactory;
import com.example.repos.Announcer;
import com.example.repos.Policeman;
import com.example.repos.impl.ConsoleAnnouncer;
import com.example.repos.impl.PolicemanImpl;
import com.example.repos.Room;

public class CoronaDisinfector {
    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    public void start(Room room) {
        announcer.announce("Начинаем дезинфекцию, все вон!");
        policeman.makePeopleLeaveRoom(); 
        disinfect(room);
        announcer.announce("Можете зайти обратно");

    }

    private void disinfect(Room room) {
        System.out.println("Происходит дезинфекция");
    }
}
