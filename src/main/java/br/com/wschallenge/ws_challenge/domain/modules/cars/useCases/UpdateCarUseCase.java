package br.com.wschallenge.ws_challenge.domain.modules.cars.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.CarRepository;
import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.ModelRepository;
import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.CarEntity;
import br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions.CarNotFoundException;
import br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions.ModelNotfoundException;

@Service
public class UpdateCarUseCase {
  @Autowired
  private CarRepository carRepository;

  @Autowired
  private ModelRepository modelRepository;

  public void execute(UUID id, CarEntity carEntity) {

    var model = this.modelRepository.findById(carEntity.getModelo_id());
    if (model.isEmpty()) {
      throw new ModelNotfoundException();
    }

    this.carRepository.findById(id).ifPresentOrElse((carDb) -> {
      carDb.Update(carEntity);
      this.carRepository.save(carDb);
    }, () -> {
      throw new CarNotFoundException();
    });
  }
}
