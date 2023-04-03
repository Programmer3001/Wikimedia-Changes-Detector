package com.kafka.wikimedia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.wikimedia.service.WikimediaChangesService;

@RestController
@RequestMapping("/api/v1/kafka")
public class WikimediaChangesController {
	
    @Autowired
    private WikimediaChangesService wikimediaChangesService;
   
    @GetMapping("/sendMessage")
    public ResponseEntity<String> sendMessage() throws InterruptedException{
    	wikimediaChangesService.sendMessage();
        return ResponseEntity.ok("Message sent to the topic");
    }

}
