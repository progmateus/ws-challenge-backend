package br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions;

public class ModelNotfoundException extends RuntimeException {
  public ModelNotfoundException() {
    super("Model not found");
  }
}
