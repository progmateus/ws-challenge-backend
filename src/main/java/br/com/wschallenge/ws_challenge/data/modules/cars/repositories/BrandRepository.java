package br.com.wschallenge.ws_challenge.data.modules.cars.repositories;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.BrandEntity;

public interface BrandRepository extends JpaRepository<BrandEntity, UUID> {
  Optional<BrandEntity> findByNome(String name);

  List<BrandEntity> findByNomeContaining(String name);
}
