package bda.Clinics.service;

import bda.Clinics.dao.model.Clinic;
import bda.Clinics.dao.model.Doctor;
import bda.Clinics.dao.model.Schedule;
import bda.Clinics.dao.model.dto.request.RequestDoctorDto;
import bda.Clinics.dao.model.dto.response.ResponseDoctorDto;
import org.springframework.data.jpa.repository.EntityGraph;

import java.util.List;

public interface DoctorService {
    List<ResponseDoctorDto> getDoctorsBySpecialty(RequestDoctorDto requestDoctorDto);

    List<ResponseDoctorDto> findAll();
<<<<<<< HEAD
    public ResponseDoctorDto getById(Long doctorId);
=======
    List<Doctor> getInactiveDoctors();
    void updateDoctorStatus(Long doctorId, boolean isActive);
    List<Doctor> getAllDoctors();
    Doctor getDoctorById(Long doctorId);
    Doctor createDoctor(Doctor doctor);
    Doctor updateDoctor(Long doctorId, Doctor doctor);
    void deleteDoctor(Long doctorId);

    void addClinicToDoctor(Long doctorId, Clinic clinic);
    void addScheduleToDoctor(Long doctorId, Schedule schedule);

>>>>>>> ca36d09666c6b4914e78fdbce3c2429b31964fe1
}
