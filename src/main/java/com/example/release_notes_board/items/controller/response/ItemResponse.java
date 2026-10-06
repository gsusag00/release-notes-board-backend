package com.example.release_notes_board.items.controller.response;

import com.example.release_notes_board.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemResponse {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private Long applicationId;
    private String applicationName;
}