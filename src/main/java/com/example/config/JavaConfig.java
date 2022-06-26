package com.example.config;

import lombok.Getter;
import org.reflections.Reflections;

import java.util.Map;
import java.util.Set;

public class JavaConfig implements Config {
    @Getter
    private final Reflections scanner;
    private final Map<Class, Class> intrfc2ImplClass;

    public JavaConfig(String packageToScan, Map<Class, Class> intrfc2ImplClass) {
        this.intrfc2ImplClass = intrfc2ImplClass;
        this.scanner = new Reflections(packageToScan);
    }

    @Override
    public <T> Class<? extends T> getImplClass(Class<T> intrfc) {
        return intrfc2ImplClass.computeIfAbsent(intrfc, aClass -> {
            Set<Class<? extends T>> classes = scanner.getSubTypesOf(intrfc);
            if (classes.size() != 1) {
                throw new RuntimeException(intrfc + " don't have 1 implementation, please update your config");
            }
            return classes.iterator().next();
        });
    }
}
