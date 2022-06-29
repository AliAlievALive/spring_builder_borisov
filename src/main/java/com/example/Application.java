package com.example;

import com.example.config.JavaConfig;

import java.util.Map;

public class Application {
    public static ApplicationContext run(String packageToScan, Map<Class, Class> intfc2ImplClass) {
        JavaConfig config = new JavaConfig(packageToScan, intfc2ImplClass);
        ApplicationContext context = new ApplicationContext(config);
        ObjectFactory objectFactory = new ObjectFactory(context);
        // TODO init all singletons which are not lazy
        context.setFactory(objectFactory);
        return context;
    }
}
