package com.example.versionednotes.controller;

import com.example.versionednotes.dto.CreateNoteRequest;
import com.example.versionednotes.dto.NoteResponse;
import com.example.versionednotes.dto.UpdateNoteRequest;
import com.example.versionednotes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/notes")
@RequiredArgsConstructor
public class NoteController {
    private final NoteService noteService;

    @PostMapping
    public NoteResponse createNote(@RequestBody CreateNoteRequest createNoteRequest){
        return noteService.createNote(createNoteRequest);
    }
    @PostMapping("/{id}")
    public NoteResponse updateNote(@RequestBody UpdateNoteRequest updateNoteRequest, @PathVariable Long id){
        return noteService.updateNote(updateNoteRequest,id);
    }
}
