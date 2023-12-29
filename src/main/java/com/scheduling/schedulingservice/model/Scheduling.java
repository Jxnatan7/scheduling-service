package com.scheduling.schedulingservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;

@Document(value = "scheduling")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Scheduling {
    private String id;
    private String user_id;
    private String company_id;
    private String haircut_id;
    private LocalDate date;
    private LocalTime hour;
}
