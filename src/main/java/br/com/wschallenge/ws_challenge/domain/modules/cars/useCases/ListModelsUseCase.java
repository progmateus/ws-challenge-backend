package br.com.wschallenge.ws_challenge.domain.modules.cars.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.ModelRepository;
import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.ModelEntity;

@Service
public class ListModelsUseCase {
  @Autowired
  ModelRepository modelRepository;

  public List<ModelEntity> execute(String params) {
    return this.modelRepository.findByNomeContaining(params);
  }
}
