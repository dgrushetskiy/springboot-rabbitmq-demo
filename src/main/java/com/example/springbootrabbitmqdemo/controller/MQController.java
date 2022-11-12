package com.example.springbootrabbitmqdemo.controller;

import com.example.springbootrabbitmqdemo.model.Student;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MQController {

    @Autowired
    RabbitTemplate rabbitTemplate;

    @GetMapping("/student/{studentName}")
    private void getMessage(@PathVariable String studentName){
        Student st = new Student(1, studentName);
        rabbitTemplate.convertAndSend("Green", st);
        rabbitTemplate.convertAndSend("topic-exchange-demo","red.blue", st);
    }
}
