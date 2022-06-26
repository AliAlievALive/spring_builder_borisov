package com.example;

import com.example.config.Config;
import com.example.config.JavaConfig;
import com.example.repos.AngryPoliceman;
import com.example.repos.Policeman;
import lombok.SneakyThrows;

import java.util.HashMap;
import java.util.Map;

public class ObjectFactory {
    private static final ObjectFactory ourInstance = new ObjectFactory();
    private final Config config;

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
        config = new JavaConfig("com.example", new HashMap<>(Map.of(Policeman.class, AngryPoliceman.class)));
    }

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        Class<? extends T> implClass = type;
        if (type.isInterface()) {
            implClass = config.getImplClass(type);
        }
        T t = implClass.getDeclaredConstructor().newInstance();

        // TODO many interesting codes

        return t;
    }
}
