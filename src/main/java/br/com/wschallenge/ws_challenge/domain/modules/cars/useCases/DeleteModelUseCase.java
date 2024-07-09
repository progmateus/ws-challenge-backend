package br.com.wschallenge.ws_challenge.domain.modules.cars.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.ModelRepository;
import br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions.BrandNotFoundException;

@Service
public class DeleteModelUseCase {
  @Autowired
  private ModelRepository modelRepository;

  public void execute(UUID id) {

    this.modelRepository.findById(id).ifPresentOrElse((modelDb) -> {
      this.modelRepository.delete(modelDb);
    }, () -> {
      throw new BrandNotFoundException();
    });
  }
}
