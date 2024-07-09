package br.com.wschallenge.ws_challenge.api.modules.cars.controllers;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.CarEntity;
import br.com.wschallenge.ws_challenge.domain.modules.cars.useCases.CreateCarUseCase;
import br.com.wschallenge.ws_challenge.domain.modules.cars.useCases.DeleteCarUseCase;
import br.com.wschallenge.ws_challenge.domain.modules.cars.useCases.ListCarsUseCase;
import br.com.wschallenge.ws_challenge.domain.modules.cars.useCases.UpdateCarUseCase;
import jakarta.validation.Valid;

@CrossOrigin()
@RestController
@RequestMapping("/cars")
public class CarController {
  @Autowired
  CreateCarUseCase createCarUseCase;

  @Autowired
  ListCarsUseCase listCarsUseCase;

  @Autowired
  UpdateCarUseCase updateCarUseCase;

  @Autowired
  DeleteCarUseCase deleteCarUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody CarEntity data) {

    try {
      var result = this.createCarUseCase.execute(data);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/")
  public ResponseEntity<Object> list(@RequestParam String params) {
    try {
      var result = this.listCarsUseCase.execute(params);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(@PathVariable UUID id, @Valid @RequestBody CarEntity data) {
    try {
      this.updateCarUseCase.execute(id, data);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable UUID id) {
    try {
      this.deleteCarUseCase.execute(id);
      return ResponseEntity.status(204).build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
