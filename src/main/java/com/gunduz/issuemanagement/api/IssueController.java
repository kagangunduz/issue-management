package com.gunduz.issuemanagement.api;

import com.gunduz.issuemanagement.dto.IssueDto;
import com.gunduz.issuemanagement.service.impl.IssueServiceImpl;
import com.gunduz.issuemanagement.util.ApiPaths;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    @Autowired
    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("{id}")
    @ApiOperation(value = "Get By Id Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id", required = true) Long id) {
        IssueDto issueDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueServiceImpl.save(issueDto));
    }

    @PutMapping("{id}")
    @ApiOperation(value = "Update Operation", response = IssueDto.class)
    public ResponseEntity<IssueDto> updateIssue(@PathVariable(value = "id", required = true) Long id,
                                                @Valid @RequestBody IssueDto issueDto) {
        return ResponseEntity.ok(issueServiceImpl.update(id, issueDto));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation")
    public ResponseEntity<Boolean> deleteIssue(@PathVariable(value = "id", required = true) Long id) {
        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }
}
