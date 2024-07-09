package br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions;

public class ModelfoundException extends RuntimeException {
  public ModelfoundException() {
    super("Model already exists");
  }
}
