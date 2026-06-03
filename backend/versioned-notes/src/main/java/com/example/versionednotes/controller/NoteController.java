package com.example.versionednotes.controller;

import com.example.versionednotes.dto.CreateNoteRequest;
import com.example.versionednotes.dto.NoteResponse;
import com.example.versionednotes.dto.NoteVersionResponse;
import com.example.versionednotes.dto.UpdateNoteRequest;
import com.example.versionednotes.service.NoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    @GetMapping("/{id}")
    public NoteResponse getLatestNote(@PathVariable Long id){
        return noteService.getLatestNote(id);
    }
    @GetMapping("/{id}/versions")
    public List<NoteVersionResponse> getVersionHistory(@PathVariable Long id){
        return noteService.getVersionHistory(id);
    }
    @PostMapping("/{noteId}/restore/{versionNumber}")
    public NoteResponse restoreVersion(@PathVariable Long noteId,@PathVariable int versionNumber){
        return noteService.restoreVersion(noteId,versionNumber);
    }
}
