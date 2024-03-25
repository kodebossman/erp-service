package za.co.emmtapp.erpservice.registration.service;

import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.registration.model.dto.ModuleDTO;

import java.util.List;

public interface ModuleService {

    ModuleDTO create(ModuleDTO moduleDTO);
    ModuleDTO find(Long id);

    ModuleDTO update(ModuleDTO moduleDTO);

    boolean delete(Long id);

    List<ModuleDTO> findModulesByCourseId(Long courseId);

    PaginationResult<ModuleDTO> findAll(String search, Integer page, Integer size, String sortBy);
}
