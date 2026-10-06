package com.example.release_notes_board.items.controller;

import com.example.release_notes_board.items.Item;
import com.example.release_notes_board.items.controller.request.CreateItemRequest;
import com.example.release_notes_board.items.controller.request.ItemDto;
import com.example.release_notes_board.items.controller.request.UpdateStatusRequest;
import com.example.release_notes_board.items.controller.response.ItemResponse;
import com.example.release_notes_board.items.service.ItemService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @GetMapping
    public Page<ItemResponse> getItems(Pageable pageable) {
        return itemService.getItems(pageable);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createItem(@Valid @RequestBody CreateItemRequest request) {
        itemService.create(request);
    }

    @PatchMapping("/{id}/status")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatus(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStatusRequest request) {
        itemService.updateStatus(id, request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> getItem(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                itemService.findById(id)
        );
    }
}
