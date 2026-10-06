package com.example.release_notes_board.items.service;

import com.example.release_notes_board.applications.Application;
import com.example.release_notes_board.applications.repository.ApplicationRepository;
import com.example.release_notes_board.exception.ItemNotFoundException;
import com.example.release_notes_board.items.Item;
import com.example.release_notes_board.items.controller.request.CreateItemRequest;
import com.example.release_notes_board.items.controller.request.ItemDto;
import com.example.release_notes_board.items.controller.request.UpdateStatusRequest;
import com.example.release_notes_board.items.controller.response.ItemResponse;
import com.example.release_notes_board.items.repository.ItemRepository;
import com.example.release_notes_board.status.Status;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository itemRepository;
    private final ApplicationRepository applicationRepository;

    public Page<ItemResponse> getItems(Pageable pageable) {

        return itemRepository.findAll(pageable)
                .map(this::mapToResponse);
    }

    public Item create(CreateItemRequest request) {

        Application application = applicationRepository.findById(request.getApplicationId())
                .orElseThrow(() -> new EntityNotFoundException("There's no application with that ID"));

        Item item = new Item();
        item.setTitle(request.getTitle());
        item.setDescription(request.getDescription());
        item.setApplication(application);
        item.setStatus(Status.DRAFT);

        return itemRepository.save(item);
    }

    public Item updateStatus(Long id, UpdateStatusRequest request) {

        Item item = itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There's no Item with that ID"));

        item.setStatus(request.getStatus());

        return itemRepository.save(item);
    }

    private ItemResponse mapToResponse(Item item) {

        return new ItemResponse(
                item.getId(),
                item.getTitle(),
                item.getDescription(),
                item.getStatus(),
                item.getApplication().getId(),
                item.getApplication().getName()
        );
    }

    public ItemDto findById(Long id) {
        Item item = itemRepository.findById(id)
                .orElseThrow(() ->
                        new ItemNotFoundException(id));
        return toDto(item);
    }

    private ItemDto toDto(Item item) {
        return new ItemDto(
                item.getId(),
                item.getTitle(),
                item.getDescription(),
                item.getStatus(),
                item.getApplication().getName()
        );
    }
}
