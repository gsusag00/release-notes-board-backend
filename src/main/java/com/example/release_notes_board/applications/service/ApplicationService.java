package com.example.release_notes_board.applications.service;

import com.example.release_notes_board.applications.controller.response.ApplicationResponse;
import com.example.release_notes_board.applications.repository.ApplicationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    public List<ApplicationResponse> getApplications() {
        return applicationRepository.findAll()
                .stream()
                .map(application -> new ApplicationResponse(
                        application.getId(),
                        application.getName()
                ))
                .toList();
    }
}


