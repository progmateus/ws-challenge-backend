package br.com.wschallenge.ws_challenge.domain.modules.cars.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.BrandRepository;
import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.BrandEntity;
import br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions.BrandFoundException;

@Service
public class CreateBrandUseCase {
  @Autowired
  private BrandRepository brandRepository;

  public BrandEntity execute(BrandEntity brandEntity) {
    this.brandRepository.findByNome(brandEntity.getNome())
        .ifPresent((brand) -> {
          throw new BrandFoundException();
        });
    return this.brandRepository.save(brandEntity);
  }
}
