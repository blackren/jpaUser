package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.entity.user;
import com.example.demo.repository.userRepository;
import com.example.demo.service.userService;

public class userSerivceImpl implements userService {
  @Autowired
  private userRepository userRepository;

  @Override
  public List<user> getUserList() {
    return userRepository.findAll();
  }

  @Override
  public user findUserById(long id) {
    return userRepository.findById(id);
  }

}
