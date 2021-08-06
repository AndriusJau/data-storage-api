package com.avalanchelabs.datastorageapi.config;

import com.avalanchelabs.datastorageapi.domain.Message;
import com.avalanchelabs.datastorageapi.repositories.MessageRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;

@Configuration
public class LoadData {

    private static final Logger log = LoggerFactory.getLogger(LoadData.class);

    @Bean
    CommandLineRunner initDatabase(MessageRepository messageRepository) {

        return args -> log.info("Preloading " + messageRepository.save(new Message(
                123,
                "Something",
                LocalDateTime.of(2018,04,21,8,32,50))));
    }
}
