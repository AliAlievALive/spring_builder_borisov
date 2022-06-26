package com.example;

import com.example.config.Config;
import com.example.config.JavaConfig;
import lombok.SneakyThrows;

public class ObjectFactory {
    private static final ObjectFactory ourInstance = new ObjectFactory();
    private final Config config = new JavaConfig("com.example");

    public static ObjectFactory getInstance() {
        return ourInstance;
    }

    private ObjectFactory() {
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
