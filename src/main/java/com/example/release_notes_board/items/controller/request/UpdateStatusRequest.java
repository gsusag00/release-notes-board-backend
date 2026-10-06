package com.example.release_notes_board.items.controller.request;

import com.example.release_notes_board.status.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdateStatusRequest {

    private Status status;

}
