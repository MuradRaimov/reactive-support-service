package com.example.support.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "SupportMessage")
public class SupportMessage {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String status;
    private String description;
    private String photoUrl;
    private String creationDate;
}
