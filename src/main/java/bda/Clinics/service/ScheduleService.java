package bda.Clinics.service;

import bda.Clinics.dao.model.Schedule;
import java.util.List;

public interface ScheduleService {
    List<Schedule> getAllSchedules();
    Schedule getScheduleById(Long scheduleId);
    List<Schedule> createSchedules(List<Schedule> schedules);
    Schedule updateSchedule(Long scheduleId, Schedule schedule);
    void deleteSchedule(Long scheduleId);
}
