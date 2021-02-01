package com.gunduz.issuemanagement.service.impl;

import com.gunduz.issuemanagement.dto.IssueDto;
import com.gunduz.issuemanagement.entity.Issue;
import com.gunduz.issuemanagement.repository.IssueRepository;
import com.gunduz.issuemanagement.service.IssueService;
import com.gunduz.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;


@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public IssueServiceImpl(IssueRepository issueRepository, ModelMapper modelMapper) {
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public IssueDto save(IssueDto issue) {

        if (issue.getDate() == null) {
            throw new IllegalArgumentException("Issue Date cannot be null!");
        }

        Issue issueDb = modelMapper.map(issue, Issue.class);

        issueDb = issueRepository.save(issueDb);
        return modelMapper.map(issueDb, IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {
       Issue issue = issueRepository.getOne(id);
       return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage page = new TPage<IssueDto>();
        IssueDto[] dtos = modelMapper.map(data.getContent(), IssueDto[].class);
        page.setStat(data, Arrays.asList(dtos));
        return page;
    }

    public IssueDto update(Long id, IssueDto issueDto) {
        Issue issueDb = issueRepository.getOne(id);

        if (issueDb == null) {
            throw new IllegalArgumentException("Issue does not exist. ID: " + id);
        }

        return modelMapper.map(issueDb, IssueDto.class);
    }

    @Override
    public Boolean delete(Long id) {
        issueRepository.deleteById(id);
        return true;
    }

}
