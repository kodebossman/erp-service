package za.co.emmtapp.erpservice.registration.service;

import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.registration.model.dto.CourseDTO;
import za.co.emmtapp.erpservice.registration.model.dto.IntakeDTO;

public interface IntakeService {
    IntakeDTO create(IntakeDTO intakeDTO);

    IntakeDTO find(Long id);

    IntakeDTO update(IntakeDTO intakeDTO);

    boolean delete(Long id);
    PaginationResult<IntakeDTO> findAll(String search, Integer page, Integer size, String sortBy);
}
