package com.example.springboot_practice.Payment;

import org.springframework.stereotype.Component;

@Component
public class UpiPayment implements PaymentService{
    @Override
    public void pay(){
        System.out.println("pay via upi");
    }
}
