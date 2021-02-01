package com.gunduz.issuemanagement.dto;

import com.gunduz.issuemanagement.entity.IssueStatus;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Issue Data Transfer Object")
public class IssueDto {

    @ApiModelProperty(value = "Issue ID")
    private Long id;
    @ApiModelProperty(value = "Issue Description")
    private String description;
    @ApiModelProperty(value = "Issue Details")
    private String details;
    @ApiModelProperty(value = "Issue Date")
    private Date date;
    @ApiModelProperty(value = "Issue Status")
    private IssueStatus issueStatus;
    @ApiModelProperty(value = "Issue Assignee")
    private UserDto assignee;
    @ApiModelProperty(value = "Issue Project")
    private ProjectDto project;

}
