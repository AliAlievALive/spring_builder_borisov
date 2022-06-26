package com.example.config;

import org.reflections.Reflections;

import java.util.Set;

public class JavaConfig implements Config {
    private final Reflections scanner;

    public JavaConfig(String packageToScan) {
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> intrfc) {
        Set<Class<? extends T>> classes = scanner.getSubTypesOf(intrfc);
        if (classes.size() != 1) {
            throw new RuntimeException(intrfc + " don't have 1 implementation");
        }
        return classes.iterator().next();
    }
}
