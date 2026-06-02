package com.example.versionednotes.service;

import com.example.versionednotes.dto.CreateNoteRequest;
import com.example.versionednotes.dto.NoteResponse;
import com.example.versionednotes.dto.NoteVersionResponse;
import com.example.versionednotes.dto.UpdateNoteRequest;
import com.example.versionednotes.entity.Note;
import com.example.versionednotes.entity.NoteVersion;
import com.example.versionednotes.repository.NoteRepository;
import com.example.versionednotes.repository.NoteVersionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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

    public NoteResponse updateNote(UpdateNoteRequest updateNoteRequest, Long id) {
        Note note=noteRepository.findNoteById(id);
        int maxVersion=noteVersionRepository.HighestVersionNumbersForNote(id);
        NoteVersion noteVersion=NoteVersion.builder()
                .note(note)
                .content(updateNoteRequest.getContent())
                .versionNumber(maxVersion+1)
                .createdAt(LocalDateTime.now())
                .build();
        noteVersionRepository.save(noteVersion);

        //return response now
        return new NoteResponse(
                id,
                note.getTitle(),
                noteVersion.getContent(),
                noteVersion.getVersionNumber()
        );
    }

    public NoteResponse getLatestNote(Long id) {
        Note note =noteRepository.findNoteById(id);
        int maxVersion=noteVersionRepository.HighestVersionNumbersForNote(id);
        NoteVersion noteVersion=noteVersionRepository.getNoteVersionByVersionNumber(note,maxVersion);

        return new NoteResponse(
                id,
                note.getTitle(),
                noteVersion.getContent(),
                noteVersion.getVersionNumber()
        );
    }

    public List<NoteVersionResponse> getVersionHistory(Long id) {
        List<NoteVersion> versionHistory=noteVersionRepository.getNoteVersionsOfANoteDescending(id);
        List<NoteVersionResponse> ans=new ArrayList<>();
        for (NoteVersion noteVersion : versionHistory) {
            ans.add(new NoteVersionResponse(noteVersion.getVersionNumber(), noteVersion.getContent()));
        }
        return ans;
    }
}
