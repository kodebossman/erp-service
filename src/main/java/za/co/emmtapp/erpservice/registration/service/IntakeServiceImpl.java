package za.co.emmtapp.erpservice.registration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;
import za.co.emmtapp.erpservice.registration.model.Intake;
import za.co.emmtapp.erpservice.registration.model.Module;
import za.co.emmtapp.erpservice.registration.model.dto.IntakeDTO;
import za.co.emmtapp.erpservice.registration.repository.IntakeRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IntakeServiceImpl implements IntakeService {

    private final IntakeRepository intakeRepository;

    @Override
    public IntakeDTO create(IntakeDTO intakeDTO) {
        Intake intake = new Intake();
        BeanUtils.copyProperties(intakeDTO, intake);
        Intake savedIntake = intakeRepository.save(intake);
        BeanUtils.copyProperties(savedIntake, intakeDTO);
        return intakeDTO;
    }

    @Override
    public IntakeDTO find(Long id) {
        IntakeDTO intakeDTO = new IntakeDTO();
        Intake intake =  intakeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Intake with Id " + " not found")
        );
        BeanUtils.copyProperties(intake, intakeDTO);
        return intakeDTO;
    }

    @Override
    public IntakeDTO update(IntakeDTO intakeDTO) {
        if (intakeDTO != null) {
            Intake intake = intakeRepository.findById(intakeDTO.getId()).orElseThrow(
                    () -> new ResourceNotFoundException("Intake with Id " + intakeDTO.getId() + " not found")
            );

            BeanUtils.copyProperties(intakeDTO, intake);

            Intake savedIntake = intakeRepository.save(intake);
            BeanUtils.copyProperties(savedIntake, intakeDTO);
        }
        return intakeDTO;
    }

    @Override
    public boolean delete(Long id) {
        intakeRepository.deleteById(id);
        return true;
    }

    @Override
    public PaginationResult<IntakeDTO> findAll(String search, Integer page, Integer size, String sortBy) {
        var pageable = PageRequest.of(page - 1, size, Sort.by(sortBy));
        Page<Intake> pageResult = intakeRepository.findAll(pageable);

        List<IntakeDTO> courseDTOs = pageResult.getContent().stream()
                .map(this::convertToIntakeDto)
                .toList();

        return PaginationResult.pagination(courseDTOs, pageResult.getTotalElements(), page, size);
    }

    private IntakeDTO convertToIntakeDto(Intake intake) {
        IntakeDTO intakeDTO = new IntakeDTO();
        intakeDTO.setId(intake.getId());
        intakeDTO.setIntakeName(intake.getIntakeName());
        intakeDTO.setCourseId(intakeDTO.getCourseId());
        intakeDTO.setEndDate(intake.getEndDate());
        intakeDTO.setCourseId(intake.getCourseId());
        intakeDTO.setStartDate(intake.getStartDate());

        return intakeDTO;
    }
}
