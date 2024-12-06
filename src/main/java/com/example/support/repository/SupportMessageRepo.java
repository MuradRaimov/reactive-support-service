package com.example.support.repository;

import com.example.support.model.SupportMessage;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SupportMessageRepo extends MongoRepository<SupportMessage, String> {
}
