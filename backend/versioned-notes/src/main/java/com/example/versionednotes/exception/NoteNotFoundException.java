package com.example.versionednotes.exception;

public class NoteNotFoundException
        extends RuntimeException {

    public NoteNotFoundException(
            String message
    ) {
        super(message);
    }
}