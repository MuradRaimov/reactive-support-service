package com.example.support.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupportMessageDto {
    private String firstName;
    private String lastName;
    private String description;
}
