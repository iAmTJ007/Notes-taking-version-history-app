package com.example.versionednotes.repository;

import com.example.versionednotes.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface NoteRepository extends JpaRepository<Note,Long> {
    @Query("""
        select n from Note n where n.id=:id
""")
    Note findNoteById(Long id);
}
