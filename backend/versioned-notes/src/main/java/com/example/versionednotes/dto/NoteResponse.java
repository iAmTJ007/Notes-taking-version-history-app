package com.example.versionednotes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoteResponse {
    private Long id;
    private String title;
    private String content;
    private int version;
}
