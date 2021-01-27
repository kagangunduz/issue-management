package com.gunduz.issuemanagement.service;

import com.gunduz.issuemanagement.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {

    User save(User user);

    User getById(Long Id);

    Page<User> getAllPageable(Pageable pageable);

    User getByUsername(String username);
}
