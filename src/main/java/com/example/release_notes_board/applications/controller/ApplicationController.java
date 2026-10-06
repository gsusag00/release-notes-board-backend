package com.example.release_notes_board.applications.controller;

import com.example.release_notes_board.applications.controller.response.ApplicationResponse;
import com.example.release_notes_board.applications.service.ApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/applications")
@RequiredArgsConstructor
public class ApplicationController {

    private final ApplicationService applicationService;

    @GetMapping
    public List<ApplicationResponse> getApplications() {
        return applicationService.getApplications();
    }
}
