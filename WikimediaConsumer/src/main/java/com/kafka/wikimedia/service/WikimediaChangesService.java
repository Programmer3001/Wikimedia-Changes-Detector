package com.kafka.wikimedia.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.kafka.wikimedia.entity.WikimediaEntity;
import com.kafka.wikimedia.repository.WikimediaRepository;


@Service
public class WikimediaChangesService {

    private static final Logger LOGGER = LoggerFactory.getLogger(WikimediaChangesService.class);

    
    private WikimediaRepository dataRepository;

    public WikimediaChangesService(WikimediaRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(
            topics = "${spring.kafka.topic.name}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void consume(String eventMessage){

        LOGGER.info(String.format("Event message received -> %s", eventMessage));

        WikimediaEntity wikimediaData = new WikimediaEntity();
        wikimediaData.setWikiEventData(eventMessage.substring(0, 20));
        dataRepository.save(wikimediaData);
    }
}