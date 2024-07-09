package br.com.wschallenge.ws_challenge.domain.modules.cars.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.CarRepository;
import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.CarEntity;

@Service
public class ListCarsUseCase {
  @Autowired
  CarRepository carRepository;

  public List<CarEntity> execute(String param) {
    return this.carRepository.findByCorContainingOrCombustivelContainingOrAnoContaining(param, param, param);
  }
}
