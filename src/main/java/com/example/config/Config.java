package com.example.config;

import org.reflections.Reflections;

public interface Config {
    <T> Class<? extends T> getImplClass(Class<T> intrfc);

    Reflections getScanner();
}
