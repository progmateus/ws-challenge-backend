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

import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.ModelEntity;
import br.com.wschallenge.ws_challenge.domain.modules.cars.useCases.CreateModelUseCase;
import br.com.wschallenge.ws_challenge.domain.modules.cars.useCases.DeleteModelUseCase;
import br.com.wschallenge.ws_challenge.domain.modules.cars.useCases.ListModelsUseCase;
import br.com.wschallenge.ws_challenge.domain.modules.cars.useCases.UpdateModelUseCase;
import jakarta.validation.Valid;

@CrossOrigin()
@RestController
@RequestMapping("/models")
public class ModelController {
  @Autowired
  CreateModelUseCase createModelUseCase;

  @Autowired
  ListModelsUseCase listModelsUseCase;

  @Autowired
  UpdateModelUseCase updateModelUseCase;

  @Autowired
  DeleteModelUseCase deleteModelUseCase;

  @PostMapping("/")
  public ResponseEntity<Object> create(@Valid @RequestBody ModelEntity data) {
    try {
      var result = this.createModelUseCase.execute(data);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @GetMapping("/")
  public ResponseEntity<Object> list(@RequestParam(required = false) String params) {
    try {
      var result = this.listModelsUseCase.execute(params);
      return ResponseEntity.ok().body(result);
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Object> update(@PathVariable UUID id, @Valid @RequestBody ModelEntity data) {
    try {
      this.updateModelUseCase.execute(id, data);
      return ResponseEntity.ok().build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> delete(@PathVariable UUID id) {
    try {
      this.deleteModelUseCase.execute(id);
      return ResponseEntity.status(204).build();
    } catch (Exception e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }
}
