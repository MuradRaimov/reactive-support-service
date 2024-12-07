package com.example.support.service;

import com.example.support.dto.SupportMessageDto;
import com.example.support.model.SupportMessage;
import com.example.support.repository.SupportMessageRepo;
import com.example.support.util.SupportMessageStatus;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Data
@Service
@RequiredArgsConstructor
public class SupportService {

    private final SupportMessageRepo supportMessageRepo;
    private final MinioService minioService;

    @Transactional
    public String newMessageFromClientToSupportService(SupportMessageDto supportMessageDto, MultipartFile file) {

        String filePath = minioService.uploadFile(file);

        SupportMessage supportMessage = new SupportMessage();
        supportMessage.setFirstName(supportMessageDto.getFirstName());
        supportMessage.setLastName(supportMessageDto.getLastName());
        supportMessage.setDescription(supportMessageDto.getDescription());
        supportMessage.setCreationDate(LocalDate.now());
        supportMessage.setStatus(SupportMessageStatus.NEW.name());
        supportMessage.setPhotoUrl(filePath);
        supportMessageRepo.save(supportMessage);

        return "Success";
    }

}
