package br.com.wschallenge.ws_challenge.data.modules.cars.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.CarEntity;

public interface CarRepository extends JpaRepository<CarEntity, UUID> {
  List<CarEntity> findByCorContainingOrCombustivelContainingOrAnoContaining(String ano, String cor, String combustivel);
}
