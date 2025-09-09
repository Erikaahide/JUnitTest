package com.example.demo.service;

import com.example.demo.model.User;
import java.util.*;

public interface UserRepository {
  List<User> findAll();
  Optional<User> findById(Long id);
  User save(User user);
}
