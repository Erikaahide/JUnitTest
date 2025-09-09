package com.example.demo.service;

import com.example.demo.model.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {
  @Mock UserRepository repository;
  @InjectMocks UserService service;

  @Test
  @DisplayName("findAll delega en repo")
  void findAll_ok() {
    when(repository.findAll()).thenReturn(List.of(new User(1L,"Erika","e@mail.com")));
    var result = service.findAll();
    assertEquals(1, result.size());
    verify(repository).findAll();
  }

  @Test
  @DisplayName("findById vacío")
  void findById_empty() {
    when(repository.findById(99L)).thenReturn(Optional.empty());
    assertTrue(service.findById(99L).isEmpty());
  }

  @Test
  @DisplayName("create válido")
  void create_valid() {
    when(repository.save(any())).thenAnswer(inv -> inv.getArgument(0));
    var user = service.create("Rodri","rodri@mail.com");
    assertEquals("Rodri", user.name());
    verify(repository).save(any());
  }

  @Test
  @DisplayName("create inválido")
  void create_invalid_email() {
    assertThrows(IllegalArgumentException.class, () -> service.create("Jess","bademail"));
  }
}
