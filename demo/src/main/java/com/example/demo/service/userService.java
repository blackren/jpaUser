package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.user;

public interface userService {
  public List<user> getUserList();

  public user findUserById(long id);
}
