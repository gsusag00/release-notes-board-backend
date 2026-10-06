package com.example.release_notes_board.exception;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException(Long id) {
        super("Item with id " + id + " was not found");
    }
}