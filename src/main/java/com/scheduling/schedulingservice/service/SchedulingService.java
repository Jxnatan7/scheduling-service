package com.scheduling.schedulingservice.service;

import com.scheduling.schedulingservice.dto.request.SchedulingRequest;
import com.scheduling.schedulingservice.dto.response.SchedulingResponse;
import com.scheduling.schedulingservice.model.Scheduling;
import com.scheduling.schedulingservice.repository.SchedulingRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SchedulingService {
    private final SchedulingRepository schedulingRepository;

    public void createScheduling(SchedulingRequest schedulingRequest) {
        Scheduling scheduling = Scheduling.builder()
                .user_id(schedulingRequest.getUser_id())
                .company_id(schedulingRequest.getCompany_id())
                .haircut_id(schedulingRequest.getHaircut_id())
                .date(schedulingRequest.getDate())
                .hour(schedulingRequest.getHour())
                .build();

        schedulingRepository.save(scheduling);
        log.info("Scheduling " + scheduling.getId() + " is saved");
    }

    public List<SchedulingResponse> getAllSchedulings() {
        List<Scheduling> schedulings = schedulingRepository.findAll();

        return schedulings.stream().map(this::mapToSchedulingResponse).toList();
    }

    public void updateScheduling(String schedulingId, SchedulingRequest schedulingRequest) {
        Optional<Scheduling> optionalScheduling = schedulingRepository.findById(schedulingId);

        if (optionalScheduling.isEmpty()) {
            log.warn("Scheduling with ID " + schedulingId + " not found");
        }

        Scheduling existingScheduling = optionalScheduling.get();
        existingScheduling.setUser_id(schedulingRequest.getUser_id());
        existingScheduling.setCompany_id(schedulingRequest.getCompany_id());
        existingScheduling.setHaircut_id(schedulingRequest.getHaircut_id());
        existingScheduling.setDate(schedulingRequest.getDate());
        existingScheduling.setHour(schedulingRequest.getHour());

        schedulingRepository.save(existingScheduling);
        log.info("Scheduling " + schedulingId + " is updated");
    }

    private SchedulingResponse mapToSchedulingResponse(Scheduling scheduling) {
        return SchedulingResponse.builder()
                .id(scheduling.getId())
                .user_id(scheduling.getUser_id())
                .company_id(scheduling.getCompany_id())
                .haircut_id(scheduling.getHaircut_id())
                .date(scheduling.getDate())
                .hour(scheduling.getHour())
                .build();
    }

    public Optional<SchedulingResponse> detailScheduling(String SchedulingId) {
        Optional<Scheduling> optionalScheduling = schedulingRepository.findById(SchedulingId);

        return optionalScheduling.map(scheduling ->
                SchedulingResponse.builder()
                        .id(scheduling.getId())
                        .user_id(scheduling.getUser_id())
                        .company_id(scheduling.getCompany_id())
                        .haircut_id(scheduling.getHaircut_id())
                        .date(scheduling.getDate())
                        .hour(scheduling.getHour())
                        .build()
        );
    }
}
