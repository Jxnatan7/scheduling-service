package com.scheduling.schedulingservice.repository;

import com.scheduling.schedulingservice.model.Scheduling;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SchedulingRepository extends MongoRepository<Scheduling, String> {
}
