package com.gunduz.issuemanagement.api;

import com.gunduz.issuemanagement.dto.ProjectDto;
import com.gunduz.issuemanagement.service.impl.ProjectServiceImpl;
import com.gunduz.issuemanagement.util.ApiPaths;
import com.gunduz.issuemanagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping(ApiPaths.ProjectCtrl.CTRL)
@Api
@Slf4j
public class ProjectController {

    private final ProjectServiceImpl projectServiceImpl;

    @Autowired
    public ProjectController(ProjectServiceImpl projectServiceImpl) {
        this.projectServiceImpl = projectServiceImpl;
    }


    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = ProjectDto.class)
    public ResponseEntity<TPage<ProjectDto>> getAllByPagination(Pageable pageable) {
        TPage<ProjectDto> data = projectServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }


    //GET
    @GetMapping("{id}")
    @ApiOperation(value = "Get By Id Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> getById(@PathVariable(value = "id", required = true) Long id) {
        log.info("ProjectController -> GetById");
        log.debug("ProjectController -> GetById -> PARAM: " + id);
        ProjectDto projectDto = projectServiceImpl.getById(id);
        return ResponseEntity.ok(projectDto);
    }

    // POST
    @PostMapping()
    @ApiOperation(value = "Create Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> createProject(@Valid @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectServiceImpl.save(projectDto));
    }

    //PUT
    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation", response = ProjectDto.class)
    public ResponseEntity<ProjectDto> updateProject(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody ProjectDto projectDto) {
        return ResponseEntity.ok(projectServiceImpl.update(id, projectDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation", response = ProjectDto.class)
    public ResponseEntity<Boolean> deleteProject(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(projectServiceImpl.delete(id));
    }
}
