package za.co.emmtapp.erpservice.registration.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import za.co.emmtapp.erpservice.common.PaginationResult;
import za.co.emmtapp.erpservice.exceptions.ResourceNotFoundException;
import za.co.emmtapp.erpservice.registration.model.Module;
import za.co.emmtapp.erpservice.registration.model.dto.ModuleDTO;
import za.co.emmtapp.erpservice.registration.repository.ModuleRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {

    private final ModuleRepository moduleRepository;

    @Override
    public ModuleDTO create(ModuleDTO moduleDTO) {
        Module module = new Module();
        BeanUtils.copyProperties(moduleDTO, module);
        Module savedModule = moduleRepository.save(module);
        BeanUtils.copyProperties(savedModule, moduleDTO);
        return moduleDTO;
    }

    @Override
    public ModuleDTO find(Long id) {
        ModuleDTO moduleDTO = new ModuleDTO();
        Module module =  moduleRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("application with provided Id not found")
        );
        BeanUtils.copyProperties(module, moduleDTO);
        return moduleDTO;
    }

    @Override
    public ModuleDTO update(ModuleDTO moduleDTO) {
        if (moduleDTO != null) {
            Module module = moduleRepository.findById(moduleDTO.getId()).orElseThrow(
                    () -> new ResourceNotFoundException("Course with Id " + moduleDTO.getId() + " not found")
            );

            BeanUtils.copyProperties(moduleDTO, module);

            Module savedModule = moduleRepository.save(module);
            BeanUtils.copyProperties(savedModule, moduleDTO);
        }
        return moduleDTO;
    }

    @Override
    public boolean delete(Long id) {
        moduleRepository.deleteById(id);
        return true;
    }

    @Override
    public List<ModuleDTO> findModulesByCourseId(Long courseId) {
        ModuleDTO moduleDTO = new ModuleDTO();
        return moduleRepository.findModulesByCourseId(courseId).stream().map(this::convertToModuleDto).toList();
    }

    @Override
    public PaginationResult<ModuleDTO> findAll(String search, Integer page, Integer size, String sortBy) {
        var pageable = PageRequest.of(page - 1, size, Sort.by(sortBy));
        Page<Module> pageResult = moduleRepository.findAll(pageable);

        List<ModuleDTO> userDTOS = pageResult.getContent().stream()
                .map(this::convertToModuleDto)
                .toList();

        return PaginationResult.pagination(userDTOS, pageResult.getTotalElements(), page, size);
    }

    private ModuleDTO convertToModuleDto(Module module) {
        ModuleDTO moduleDTO = new ModuleDTO();
        BeanUtils.copyProperties(module, moduleDTO);
        return moduleDTO;
    }
}
