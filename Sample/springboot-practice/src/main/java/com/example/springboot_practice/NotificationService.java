package com.example.springboot_practice;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private final EmailNotification notification;

    public NotificationService(EmailNotification notification) {
        this.notification = notification;
    }

    public void notifyUser(String username) {
        String message = "Welcome, " + username
                + "! Your account has been created.";

        notification.send(message);
    }
}
