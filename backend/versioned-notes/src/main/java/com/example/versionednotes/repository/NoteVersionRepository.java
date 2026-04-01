package com.example.versionednotes.repository;

import com.example.versionednotes.entity.NoteVersion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NoteVersionRepository extends JpaRepository<NoteVersion,Long> {

    //making a list of all version numbers for a particular note id then taking the highest from it in logic
    @Query("""
        select n.versionNumber from NoteVersion n where n.note.id=:nid order by n.versionNumber desc
""")
    List<Integer> ListOfVersionNumbersForNote(long nid);
}
