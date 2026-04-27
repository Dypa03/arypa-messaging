package com.message_service.model.entity;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Document
public class Chat {

    @Id
    private String id;

    private String name;

    @Field(name = "created_at")
    private Instant createdAt;

    @Field(name = "chat_members")
    private List<String> chatMembers; // userIds
}
