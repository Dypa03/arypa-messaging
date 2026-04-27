package com.message_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Document
public class Message {

    @Id
    private String id;

    private String content;

    @Field(name = "created_at")
    private Instant createdAt;

    @Field(name = "delivered_at")
    private Instant deliveredAt;

    @Field(name = "sender_id")
    private Long senderId;

    @Field(name = "chat_id")
    private String chatId;
}
