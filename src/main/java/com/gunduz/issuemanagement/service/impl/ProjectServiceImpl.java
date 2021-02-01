package com.gunduz.issuemanagement.service.impl;

import com.gunduz.issuemanagement.dto.ProjectDto;
import com.gunduz.issuemanagement.entity.Project;
import com.gunduz.issuemanagement.repository.ProjectRepository;
import com.gunduz.issuemanagement.service.ProjectService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository, ModelMapper modelMapper) {
        this.projectRepository = projectRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ProjectDto save(ProjectDto projectDto) {

        Project projectCheck = projectRepository.getByProjectCode(projectDto.getProjectCode());

        if (projectCheck != null) {
            throw new IllegalArgumentException("Project Code already exist!");
        }

        Project p = modelMapper.map(projectDto, Project.class);
        p = projectRepository.save(p);
        projectDto.setId(p.getId());
        return projectDto;
    }

    @Override
    public ProjectDto getById(Long id) {
        Project project = projectRepository.getOne(id);
        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public ProjectDto getByProjectCode(String projectCode) {
        return null;
    }

    @Override
    public List<Project> getByProjectCodeContains(String projectCode) {
        return null;
    }

    @Override
    public Page<Project> getAllPageable(Pageable pageable) {
        return projectRepository.findAll(pageable);
    }

    @Override
    public ProjectDto update(Long id, ProjectDto projectDto) {

        Project projectDb = projectRepository.getOne(id);

        if (projectDb == null) {
            throw new IllegalArgumentException("Project does not exist! ID: " + id);
        }

        Project projectCheck = projectRepository.getByProjectCodeAndIdNot(projectDto.getProjectCode(), id);

        if (projectCheck != null) {
            throw new IllegalArgumentException("Project Code already exist!");
        }

        projectDb.setProjectCode(projectDto.getProjectCode());
        projectDb.setProjectName(projectDto.getProjectName());

        projectRepository.save(projectDb);
        return modelMapper.map(projectDb, ProjectDto.class);
    }


    @Override
    public Boolean delete(ProjectDto projectDto) {
        return false;
    }


    @Override
    public Boolean delete(Long id) {
        projectRepository.deleteById(id);
        return true;
    }
}
