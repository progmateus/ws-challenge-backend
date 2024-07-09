package br.com.wschallenge.ws_challenge.domain.modules.cars.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.BrandRepository;
import br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions.BrandNotFoundException;

@Service
public class DeleteBrandUseCase {
  @Autowired
  private BrandRepository brandRepository;

  public void execute(UUID id) {

    this.brandRepository.findById(id).ifPresentOrElse((brandDb) -> {
      this.brandRepository.delete(brandDb);
    }, () -> {
      throw new BrandNotFoundException();
    });
  }
}
