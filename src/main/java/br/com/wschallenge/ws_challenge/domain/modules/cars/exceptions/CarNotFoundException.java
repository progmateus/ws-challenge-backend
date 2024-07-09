package br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions;

public class CarNotFoundException extends RuntimeException {
  public CarNotFoundException() {
    super("Car not found");
  }
}
