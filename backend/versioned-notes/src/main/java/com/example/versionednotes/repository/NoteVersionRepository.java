package com.example.versionednotes.repository;

import com.example.versionednotes.entity.NoteVersion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteVersionRepository extends JpaRepository<NoteVersion,Long> {
}
