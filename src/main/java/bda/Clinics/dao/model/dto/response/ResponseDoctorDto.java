package bda.Clinics.dao.model.dto.response;

import bda.Clinics.dao.model.Schedule;
import bda.Clinics.dao.model.dto.request.RequestClinicDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ResponseDoctorDto {

    String fullName;
    String speciality;
    String qualifications;
    Double experience;
    String service;
    String serviceDescription;
    Boolean isActive;
    Set<RequestClinicDto> clinics;
    Set<ResponseReviewDto> reviews;
    Set<ResponseScheduleDto> schedules;

}
