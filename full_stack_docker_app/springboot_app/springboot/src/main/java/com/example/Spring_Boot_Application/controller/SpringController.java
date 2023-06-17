package com.example.Spring_Boot_Application.controller;

import com.example.Spring_Boot_Application.model.Topic;
import com.example.Spring_Boot_Application.service.SpringBootService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@AllArgsConstructor
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*") // This is to allow cross origin data flow between one server to another server
public class SpringController {

    private final SpringBootService springBootService;

    @GetMapping(value = "/hello")
    public String helloMethod() {
        System.out.println("hello friends");
        return "hello friends";
    }

    @GetMapping(value = "/topics")
    public Collection<Topic> listOfTopics() {
        System.out.println("listOfTopics");
        return springBootService.getAllTopics();
    }

    @GetMapping(value = "/topics/{id}")
    public Topic getRequiredTopic(@PathVariable String id) {
        System.out.println("getRequiredTopic, id: " + id);
        return springBootService.getTopic(id);
    }

    @PostMapping(value = "/topics/add")
    public String addTopic(@RequestBody Topic topic) {
        System.out.println("add the topic: " + topic);
        springBootService.addTopic(topic);
        return "Post method successFully";
    }

    @PutMapping(value = "/topics/update/{id}")
    public String updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        System.out.println("update the topic is: " + topic + ", id: " + id);
        springBootService.updateTopic(topic, id);
        return "put method successful";
    }

    @DeleteMapping(value = "/topics/delete/{id}")
    public String deleteTopic(@PathVariable String id) {
        System.out.println("delete topic by id: " + id);
        springBootService.deleteTopic(id);
        return "delete method successful";
    }

    //This endpoint will return the list of topic after delay of 5 sec
    @GetMapping(value = "/topicsWithDelay")
    public Collection<Topic> listOfTopicsWithDelay() {
        System.out.println("listOfTopicsWithDelay");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("Damn! the error occured");
        }
        return springBootService.getAllTopics();
    }

}
