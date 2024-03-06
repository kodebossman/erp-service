package za.co.emmtapp.erpservice.registration.service;

import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.registration.model.dto.ModuleDTO;

public interface ModuleService {

    ModuleDTO create(ModuleDTO moduleDTO);
    ModuleDTO find(Long id);

    boolean update(ModuleDTO moduleDTO);

    boolean delete(Long id);

    PaginationResult<ModuleDTO> findAll(String search, Integer page, Integer size, String sortBy);
}
