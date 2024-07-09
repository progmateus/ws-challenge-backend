package br.com.wschallenge.ws_challenge.data.modules.cars.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.ModelEntity;

public interface ModelRepository extends JpaRepository<ModelEntity, UUID> {
  Optional<ModelEntity> findByNome(String name);

  List<ModelEntity> findByNomeContaining(String params);
}
