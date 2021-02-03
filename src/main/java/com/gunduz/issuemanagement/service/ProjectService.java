package com.gunduz.issuemanagement.service;

import com.gunduz.issuemanagement.dto.ProjectDto;
import com.gunduz.issuemanagement.entity.Project;
import com.gunduz.issuemanagement.util.TPage;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto projectDto);

    ProjectDto getById(Long id);

    TPage<ProjectDto> getAllPageable(Pageable pageable);

    ProjectDto update(Long id, ProjectDto projectDto);

    Boolean delete(Long id);
}
