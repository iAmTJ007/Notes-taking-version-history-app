package com.example.versionednotes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NoteVersionResponse {
    private int version;
    private String content;
}
