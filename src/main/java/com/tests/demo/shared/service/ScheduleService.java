package com.tests.demo.shared.service;

import com.tests.demo.shared.constants.Constants;
import com.tests.demo.shared.exception.MainException;
import com.tests.demo.shared.model.Schedule;
import com.tests.demo.shared.repository.ScheduleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ScheduleService {

    private ScheduleRepository repository;

    public ScheduleService(ScheduleRepository scheduleRepository){
        this.repository = scheduleRepository;
    }

    public Schedule createSchedule(Schedule schedule) {
        if(schedule.getDescription() != null || schedule.getDescription().length() > 0){
            Schedule response = repository.save(schedule);
            return response;
        }
        throw new MainException(Constants.SCHEDULE.SESSION_NEEDS_DESCRIPTION);
    }

    public Schedule getSchedule(Long id){
        Optional<Schedule> schedule = repository.findById(id);
        if(schedule.isPresent()){
            return schedule.get();
        }
        throw new MainException(Constants.SCHEDULE.ERROR_NOT_FOUND);
    }


}
