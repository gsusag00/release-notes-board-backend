package com.example.release_notes_board.exception;

public class ApplicationNotFoundException extends RuntimeException {

    public ApplicationNotFoundException(Long id) {
        super("Application with id " + id + " was not found");
    }
}
