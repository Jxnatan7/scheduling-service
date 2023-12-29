package com.scheduling.schedulingservice.controller;

import com.scheduling.schedulingservice.dto.request.SchedulingRequest;
import com.scheduling.schedulingservice.dto.response.SchedulingResponse;
import com.scheduling.schedulingservice.service.SchedulingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/scheduling")
@RequiredArgsConstructor
public class SchedulingController {

    private final SchedulingService schedulingService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createScheduling(@RequestBody SchedulingRequest schedulingRequest) {
        schedulingService.createScheduling(schedulingRequest);
    }

    @PutMapping("/{schedulingId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateScheduling(@PathVariable String schedulingId, @RequestBody SchedulingRequest schedulingRequest) {
        schedulingService.updateScheduling(schedulingId, schedulingRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SchedulingResponse> getAllSchedulings() {
        return schedulingService.getAllSchedulings();
    }

    @GetMapping("/{schedulingId}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<SchedulingResponse> detailScheduling(@PathVariable String schedulingId) {
        return schedulingService.detailScheduling(schedulingId);
    }
}