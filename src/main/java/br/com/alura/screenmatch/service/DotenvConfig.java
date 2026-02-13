package br.com.alura.screenmatch.service;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;

import java.util.HashMap;
import java.util.Map;

public class DotenvConfig implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
        ConfigurableEnvironment environment = applicationContext.getEnvironment();

        Map<String, Object> map = new HashMap<>();
        dotenv.entries().forEach(entry ->
                map.put(entry.getKey(), entry.getValue())
        );

        environment.getPropertySources()
                .addFirst(new MapPropertySource("dotenvProperties", map));
    }
}