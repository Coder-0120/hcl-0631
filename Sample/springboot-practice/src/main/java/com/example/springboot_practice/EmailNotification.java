
package com.example.springboot_practice;

import org.springframework.stereotype.Component;
//@Component tells Spring that this class is eligible for component scanning and can be registered as a managed bean.
@Component
public class EmailNotification {

    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}
