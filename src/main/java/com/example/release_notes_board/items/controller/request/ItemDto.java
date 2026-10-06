package com.example.release_notes_board.items.controller.request;

import com.example.release_notes_board.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Long id;
    private String title;
    private String description;
    private Status status;
    private String applicationName;
}
