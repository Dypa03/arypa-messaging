package com.message_service.controller;

import com.message_service.model.dto.MessageDTO;
import com.message_service.model.entity.Message;
import com.message_service.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @Autowired
    MessageRepository messageRepository;

    @Autowired
    SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/chat")
    public void sendMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setContent(messageDTO.getContent());
        message.setSenderId(messageDTO.getSenderId());
        message.setChatId(messageDTO.getChatId());

        messageRepository.save(message);
        messagingTemplate.convertAndSend("/topic/messages/" + message.getChatId(), message);


    }
}
