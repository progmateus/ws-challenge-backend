package br.com.wschallenge.ws_challenge.domain.modules.cars.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.CarRepository;
import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.ModelRepository;
import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.CarEntity;
import br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions.ModelNotfoundException;

@Service
public class CreateCarUseCase {
  @Autowired
  private CarRepository carRepository;

  @Autowired
  private ModelRepository modelRepository;

  public CarEntity execute(CarEntity carEntity) {
    var model = this.modelRepository.findById(carEntity.getModelo_id());
    if (model.isEmpty()) {
      throw new ModelNotfoundException();
    }
    return this.carRepository.save(carEntity);
  }
}
