package br.com.wschallenge.ws_challenge.domain.modules.cars.useCases;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.CarRepository;
import br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions.CarNotFoundException;

@Service
public class DeleteCarUseCase {
  @Autowired
  private CarRepository carRepository;

  public void execute(UUID id) {

    this.carRepository.findById(id).ifPresentOrElse((carDb) -> {
      this.carRepository.delete(carDb);
    }, () -> {
      throw new CarNotFoundException();
    });
  }
}
