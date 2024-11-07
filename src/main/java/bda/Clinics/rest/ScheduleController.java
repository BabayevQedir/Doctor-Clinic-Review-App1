package bda.Clinics.rest;

import bda.Clinics.dao.model.Schedule;
import bda.Clinics.dao.model.dto.request.RequestScheduleDto;
import bda.Clinics.service.ClinicService;
import bda.Clinics.service.DoctorService;
import bda.Clinics.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/schedules")
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;
    private final ClinicService clinicService;
    private final DoctorService doctorService;


    @GetMapping
    public ResponseEntity<List<Schedule>> getAllSchedules() {
        List<Schedule> schedules = scheduleService.getAllSchedules();
        return ResponseEntity.ok(schedules);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Schedule> getScheduleById(@PathVariable Long id) {
        Schedule schedule = scheduleService.getScheduleById(id);
        return ResponseEntity.ok(schedule);
    }

    @PostMapping("/bulk")
    public ResponseEntity<List<Schedule>> createSchedules(@RequestBody List<RequestScheduleDto> requestScheduleDtos) {
        List<Schedule> schedules = requestScheduleDtos.stream()
                .map(this::mapToSchedule)
                .collect(Collectors.toList());
        List<Schedule> createdSchedules = scheduleService.createSchedules(schedules);
        return ResponseEntity.ok(createdSchedules);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Schedule> updateSchedule(@PathVariable Long id, @RequestBody RequestScheduleDto requestScheduleDto) {
        Schedule updatedSchedule = scheduleService.updateSchedule(id, mapToSchedule(requestScheduleDto));
        return ResponseEntity.ok(updatedSchedule);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{clinicId}/schedules")
    public ResponseEntity<Void> addScheduleToClinic(
            @PathVariable Long clinicId,
            @RequestBody RequestScheduleDto requestScheduleDto) {

        Schedule schedule = mapToSchedule(requestScheduleDto);

        clinicService.addScheduleToClinic(clinicId, schedule);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{doctorId}/schedules")
    public ResponseEntity<Void> addScheduleToDoctor(
            @PathVariable Long doctorId,
            @RequestBody RequestScheduleDto requestScheduleDto) {

        Schedule schedule = mapToSchedule(requestScheduleDto);

        doctorService.addScheduleToDoctor(doctorId, schedule);
        return ResponseEntity.ok().build();
    }
    private Schedule mapToSchedule(RequestScheduleDto dto) {
        return Schedule.builder()
                .weekDay(dto.getWeekDay())
                .workingHoursFrom(LocalTime.parse(dto.getWorkingHoursFrom())) // "hh:mm" format
                .workingHoursTo(LocalTime.parse(dto.getWorkingHoursTo()))     // "hh:mm" format
                .build();
    }

}
