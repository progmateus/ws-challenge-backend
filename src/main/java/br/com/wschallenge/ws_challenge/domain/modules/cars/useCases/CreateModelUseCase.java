package br.com.wschallenge.ws_challenge.domain.modules.cars.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.BrandRepository;
import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.ModelRepository;
import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.ModelEntity;
import br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions.BrandNotFoundException;
import br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions.ModelfoundException;

@Service
public class CreateModelUseCase {
  @Autowired
  private ModelRepository modelRepository;

  @Autowired
  private BrandRepository brandRepository;

  public ModelEntity execute(ModelEntity modelEntity) {
    this.modelRepository.findByNome(modelEntity.getNome())
        .ifPresent((model) -> {
          throw new ModelfoundException();
        });
    var brand = brandRepository.findById(modelEntity.getMarca_id());
    if (brand.isEmpty()) {
      throw new BrandNotFoundException();
    }
    return this.modelRepository.save(modelEntity);
  }
}
