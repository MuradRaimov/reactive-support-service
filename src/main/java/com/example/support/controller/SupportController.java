package com.example.support.controller;

import com.example.support.dto.SupportMessageDto;
import com.example.support.service.SupportService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Data
@RestController
@RequestMapping("/api/supports")
@RequiredArgsConstructor
public class SupportController {

    private final SupportService supportService;

    @PostMapping
    public ResponseEntity<String> create (@RequestPart("complaint") SupportMessageDto supportMessageDto,
                                          @RequestPart("file") MultipartFile file) {
        return new ResponseEntity<String>(supportService.newMessage(supportMessageDto, file), HttpStatus.CREATED);
    }
}
