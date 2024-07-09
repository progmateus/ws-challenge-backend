package br.com.wschallenge.ws_challenge.domain.modules.cars.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.BrandRepository;
import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.ModelRepository;
import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.ModelEntity;
import br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions.BrandNotFoundException;
import br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions.ModelNotfoundException;

@Service
public class UpdateModelUseCase {
  @Autowired
  private BrandRepository brandrepository;

  @Autowired
  private ModelRepository modelRepository;

  public void execute(UUID id, ModelEntity modelEntity) {

    var brand = this.brandrepository.findById(modelEntity.getMarca_id());
    if (brand.isEmpty()) {
      throw new BrandNotFoundException();
    }

    this.modelRepository.findById(id).ifPresentOrElse((modelDb) -> {
      modelDb.Update(modelEntity);
      this.modelRepository.save(modelDb);
    }, () -> {
      throw new ModelNotfoundException();
    });
  }
}
