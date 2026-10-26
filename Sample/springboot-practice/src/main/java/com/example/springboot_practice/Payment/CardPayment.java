package com.example.springboot_practice.Payment;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("up")
public class CardPayment implements PaymentService{
    @Override
    public void pay(){
        System.out.println("Paying via Card");
    }
}
