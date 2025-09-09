package com.example.demo.service;

import com.example.demo.model.User;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class UserService {
  private final UserRepository repository;
  private final AtomicLong seq = new AtomicLong(0);

  public UserService(UserRepository repository) {
    this.repository = repository;
  }

  public List<User> findAll() {
    return repository.findAll();
  }

  public Optional<User> findById(Long id) {
    return repository.findById(id);
  }

  public User create(String name, String email) {
    if (name == null || name.isBlank()) {
      throw new IllegalArgumentException("name is required");
    }
    if (email == null || !email.contains("@")) {
      throw new IllegalArgumentException("email is invalid");
    }
    var user = new User(seq.incrementAndGet(), name, email);
    return repository.save(user);
  }
}
