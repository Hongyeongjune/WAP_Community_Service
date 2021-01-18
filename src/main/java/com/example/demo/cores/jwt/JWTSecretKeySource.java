package com.example.demo.cores.jwt;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class JWTSecretKeySource {

    private static final String YAML_FILE_NAME = "application.properties";

    public static String readSecretKey() {
        try {
            Properties properties = new Properties();
            InputStream input = JWTSecretKeySource.class
                    .getClassLoader()
                    .getResourceAsStream(
                            String.format(
                                    YAML_FILE_NAME, System.getenv("--spring.profiles.active")
                            )
                    );
            if(input == null) {
                input = JWTSecretKeySource
                        .class.getClassLoader()
                        .getResourceAsStream("application.properties");
            }
            properties.load(input);
            return properties.getProperty("spring.jwt.secret");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
