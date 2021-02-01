package com.gunduz.issuemanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "Project Data Transfer Object")
public class ProjectDto {

    @ApiModelProperty(value = "Project ID")
    private Long id;
    @NotNull
    @ApiModelProperty(value = "Name of Project", required = true)
    private String projectName;
    @NotNull
    @ApiModelProperty(value = "Code of Project", required = true)
    private String projectCode;

}
