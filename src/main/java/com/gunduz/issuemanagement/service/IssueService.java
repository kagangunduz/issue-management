package com.gunduz.issuemanagement.service;

import com.gunduz.issuemanagement.dto.IssueDto;
import com.gunduz.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long id);

    IssueDto update(Long id, IssueDto issueDto);

}
