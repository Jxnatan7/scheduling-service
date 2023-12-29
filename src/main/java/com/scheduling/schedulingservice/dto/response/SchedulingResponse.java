package com.scheduling.schedulingservice.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SchedulingResponse {
    private String id;
    private String user_id;
    private String company_id;
    private String haircut_id;
    private LocalDate date;
    private LocalTime hour;
}
