
package com.example.springboot_practice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringbootPracticeApplication {

	public static void main(String[] args) {

//		ConfigurableApplicationContext context =
//				SpringApplication.run(
//						SpringbootPracticeApplication.class, args);
//
//		NotificationService service =
//				context.getBean(NotificationService.class);
//
//		service.notifyUser("Anshul");
//		PaymentService paymentService=new PaymentService();
//		OrderService order =new OrderService(paymentService);
//		order.placeOrder();

		ApplicationContext context =new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService order=context.getBean(OrderService.class);
		order.placeOrder();

	}
}
