package com.example.release_notes_board.items.controller.request;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CreateItemRequest {

    private String title;
    private String description;
    private Long applicationId;

}