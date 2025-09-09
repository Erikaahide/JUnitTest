package com.example.demo.controller;

import com.example.demo.dto.CreateUserRequest;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  private final UserService service;
  public UserController(UserService service) {
    this.service = service;
  }

  @GetMapping
  public List<User> all() {
    return service.findAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<User> byId(@PathVariable Long id) {
    return service.findById(id)
        .map(ResponseEntity::ok)
        .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
  }

  @PostMapping
  public ResponseEntity<User> create(@Valid @RequestBody CreateUserRequest dto) {
    var created = service.create(dto.name(), dto.email());
    return ResponseEntity.status(HttpStatus.CREATED).body(created);
  }
}
