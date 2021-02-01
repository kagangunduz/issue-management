package com.gunduz.issuemanagement.service;

import com.gunduz.issuemanagement.dto.ProjectDto;
import com.gunduz.issuemanagement.entity.Project;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService {

    ProjectDto save(ProjectDto projectDto);

    ProjectDto getById(Long id);

    ProjectDto getByProjectCode(String projectCode);

    List<Project> getByProjectCodeContains(String projectCode);

    Page<Project> getAllPageable(Pageable pageable);

    ProjectDto update(Long id, ProjectDto projectDto);

    Boolean delete(ProjectDto projectDto);

    Boolean delete(Long id);
}
