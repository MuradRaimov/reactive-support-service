package com.example.support.controller;

import com.example.support.dto.SupportMessageDto;
import com.example.support.service.SupportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/supports")
public class SupportController {

    private final SupportService supportService;

    public SupportController(SupportService supportService) {
        this.supportService = supportService;
    }

    @PostMapping("/new-message")
    public ResponseEntity<String> create(@RequestPart("message") SupportMessageDto supportMessageDto,
                                         @RequestPart("file") MultipartFile file) {
        return ResponseEntity.ok(supportService.newMessageFromClientToSupportService(supportMessageDto, file));
    }
}
