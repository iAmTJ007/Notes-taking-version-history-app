package com.example.versionednotes.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "note_versions")
public class NoteVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private int versionNumber;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name="note_id",nullable = false)
    private Note note;
}
