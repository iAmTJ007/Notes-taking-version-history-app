package com.example.versionednotes.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateNoteRequest {
    @NotBlank(message = "title should not be blank")
    private String title;
    private String content;
}
