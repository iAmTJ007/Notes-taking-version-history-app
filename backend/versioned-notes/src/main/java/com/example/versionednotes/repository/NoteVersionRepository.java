package com.example.versionednotes.repository;

import com.example.versionednotes.entity.Note;
import com.example.versionednotes.entity.NoteVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteVersionRepository extends JpaRepository<NoteVersion,Long> {

    //getting highest note version
    @Query("""
        select max(n.versionNumber) from NoteVersion n where n.note.id=:nid
""")
    int HighestVersionNumbersForNote(long nid);
    //get noteversion by version number of a note
    @Query("""
        select n from NoteVersion n where n.note=:note and n.versionNumber=:versionNumber 
""")
    NoteVersion getNoteVersionByVersionNumber(Note note, int versionNumber);
}
