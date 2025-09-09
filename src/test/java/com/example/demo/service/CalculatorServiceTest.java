package com.example.demo.service;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorServiceTest {
  private CalculatorService calc;

  @BeforeAll
  static void beforeAll() { System.out.println(">> BEFORE ALL"); }

  @AfterAll
  static void afterAll() { System.out.println(">> AFTER ALL"); }

  @BeforeEach
  void setUp() { calc = new CalculatorService(); }

  @AfterEach
  void tearDown() {}

  @Test
  @DisplayName("Suma básica 2 + 3 = 5")
  void add_ok() { assertEquals(5, calc.add(2, 3)); }

  @Test
  @DisplayName("Divide by zero throws")
  void divide_by_zero() {
    assertThrows(ArithmeticException.class, () -> calc.divide(10, 0));
  }

  @Test
  @Disabled("Ejemplo deshabilitado")
  void disabled_example() { fail("No debería ejecutarse"); }

  @ParameterizedTest(name = "{0} + {1} = {2}")
  @CsvSource({"0,0,0","1,2,3","-1,1,0","10,5,15"})
  void add_param(int a, int b, int expected) {
    assertEquals(expected, calc.add(a, b));
  }
}
