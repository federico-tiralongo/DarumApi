package com.postgresql.Daruma.config.security;

import java.io.FileInputStream;
import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

@Configuration
public class FirebaseConfig {

    @Bean
    FirebaseApp firebaseApp() throws IOException {
        // Check if firebase was already initialized
        if (FirebaseApp.getApps().isEmpty()) {
            FileInputStream serviceAccountStream = new FileInputStream("firebase.json");
            FirebaseOptions firebaseOptions = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(
                            serviceAccountStream))
                    .build();
            serviceAccountStream.close();
            return FirebaseApp.initializeApp(firebaseOptions);
        }
        return FirebaseApp.getInstance();
    }
}
