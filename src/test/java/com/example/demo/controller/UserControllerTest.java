package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
class UserControllerTest {
  @Autowired MockMvc mockMvc;
  @MockBean UserService service;

  @Test
  @DisplayName("GET /users OK")
  void get_users() throws Exception {
    when(service.findAll()).thenReturn(List.of(new User(1L,"Erika","e@mail.com")));
    mockMvc.perform(get("/users"))
        .andExpect(status().isOk())
        .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$[0].name").value("Erika"));
  }

  @Test
  @DisplayName("GET /users/1 OK")
  void get_user_by_id() throws Exception {
    when(service.findById(1L)).thenReturn(Optional.of(new User(1L,"Erika","e@mail.com")));
    mockMvc.perform(get("/users/1"))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.email").value("e@mail.com"));
  }

  @Test
  @DisplayName("POST /users created")
  void post_user() throws Exception {
    when(service.create("Rodri","rodri@mail.com")).thenReturn(new User(10L,"Rodri","rodri@mail.com"));
    String json = "{\"name\":\"Rodri\",\"email\":\"rodri@mail.com\"}";
    mockMvc.perform(post("/users").contentType(MediaType.APPLICATION_JSON).content(json))
        .andExpect(status().isCreated())
        .andExpect(jsonPath("$.id").value(10));
  }
}
