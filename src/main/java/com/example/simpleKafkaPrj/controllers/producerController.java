package com.example.simpleKafkaPrj.controllers;

import com.example.simpleKafkaPrj.services.Producer;
import com.example.simpleKafkaPrj.streams.CountStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producer")
public class producerController {

    private List<String> stringArrayList;

    private List<Integer> integerArrayList;

    @Autowired
    private Producer producer;

    @Autowired
    private CountStream countStream;


    @GetMapping("/send")
    public ResponseEntity<String> send() {
        producer.sendString(stringArrayList);
        countStream.countStreamProp();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count")
    public ResponseEntity<String> count()
    {
        countStream.countStreamProp();
        return ResponseEntity.ok().build();
    }

    public void setStringArrayList(List<String> stringArrayList) {
        this.stringArrayList = stringArrayList;
    }

    public void setIntegerArrayList(List<Integer> integerArrayList) {
        this.integerArrayList = integerArrayList;
    }
}
