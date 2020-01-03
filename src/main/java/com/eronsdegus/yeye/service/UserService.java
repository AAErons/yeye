package com.eronsdegus.yeye.service;

import com.eronsdegus.yeye.dto.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
