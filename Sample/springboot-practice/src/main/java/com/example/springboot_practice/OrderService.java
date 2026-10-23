package com.example.springboot_practice;

import com.example.springboot_practice.Payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class OrderService {
    private PaymentService paymentService;
    @Autowired
    public OrderService(@Qualifier("up") PaymentService paymentService){
        this.paymentService=paymentService;
    }


    public void placeOrder(){
        paymentService.pay();
        System.out.println("Order is placed");
    }
}
