package com.example.support.service;

import com.example.support.dto.SupportMessageDto;
import com.example.support.model.SupportMessage;
import com.example.support.repository.SupportMessageRepo;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Data
@Service
@RequiredArgsConstructor
public class SupportService {

    private final SupportMessageRepo supportMessageRepo;

    private final MinioService minioService;

    public String newMessage(SupportMessageDto supportMessageDto, MultipartFile file) {
        return null;
    }

}
