package com.example.versionednotes.service;

import com.example.versionednotes.dto.CreateNoteRequest;
import com.example.versionednotes.dto.NoteResponse;
import com.example.versionednotes.entity.Note;
import com.example.versionednotes.entity.NoteVersion;
import com.example.versionednotes.repository.NoteRepository;
import com.example.versionednotes.repository.NoteVersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class NoteService {
    private final NoteRepository noteRepository;
    private final NoteVersionRepository noteVersionRepository;

    public NoteResponse createNote(CreateNoteRequest createNoteRequest) {
        Note note=Note.builder()
                .title(createNoteRequest.getTitle())
                .build();
        noteRepository.save(note);

        NoteVersion noteVersion= NoteVersion.builder()
                .note(note)
                .content(createNoteRequest.getContent())
                .versionNumber(1)
                .createdAt(LocalDateTime.now())
                .build();
        noteVersionRepository.save(noteVersion);

        //return response now
        return new NoteResponse(
                note.getId(),
                note.getTitle(),
                noteVersion.getContent(),
                noteVersion.getVersionNumber()
        );
    }
}
