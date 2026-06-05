package com.message_service;

import com.message_service.model.entity.Message;
import com.message_service.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories
public class Application {

	@Autowired
	MessageRepository messageRepository;

	List<Message> messages = new ArrayList<Message>();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
