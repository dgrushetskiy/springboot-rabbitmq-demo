package com.example.springbootrabbitmqdemo.service;

import com.example.springbootrabbitmqdemo.model.Student;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MQListener {

    @RabbitListener(queues="Red")
    public void getMessageRed(Student student){
        System.out.println("Received message in Red queue for student - " + student.getName() );
    }

    @RabbitListener(queues="Blue")
    public void getMessageBlue(Student student){
        System.out.println("Received message in Blue queue for student - " + student.getName() );
    }

    @RabbitListener(queues="Green")
    public void getMessageGreen(Student student){
        System.out.println("Received message in Green queue for student - " + student.getName() );
    }
}
