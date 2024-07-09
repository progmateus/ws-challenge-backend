package br.com.wschallenge.ws_challenge.domain.modules.cars.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.BrandRepository;
import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.BrandEntity;
import br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions.BrandNotFoundException;

@Service
public class UpdateBrandUseCase {
  @Autowired
  private BrandRepository brandrepository;

  public void execute(UUID id, BrandEntity brandEntity) {

    this.brandrepository.findById(id).ifPresentOrElse((modelDb) -> {
      modelDb.Update(brandEntity);
      this.brandrepository.save(modelDb);
    }, () -> {
      throw new BrandNotFoundException();
    });
  }
}
