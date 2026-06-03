package com.example.versionednotes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateNoteRequest {
    private String content;
}
