package com.message_service.repositories;

import com.message_service.model.entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface MessageRepository extends MongoRepository<Message, String> {

    @Query("{content:'?0'}")
    Message findMessageByContent(String content);

    @Query(value = "{sender_id:'?0'}", fields = "{'content':1}")
    List<Message> findAllBySender(Long senderId);

    public long count();

}
