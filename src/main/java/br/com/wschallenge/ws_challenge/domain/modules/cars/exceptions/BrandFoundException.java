package br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions;

public class BrandFoundException extends RuntimeException {
  public BrandFoundException() {
    super("Brand already exists");
  }
}
