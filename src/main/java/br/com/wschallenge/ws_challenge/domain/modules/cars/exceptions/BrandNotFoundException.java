package br.com.wschallenge.ws_challenge.domain.modules.cars.exceptions;

public class BrandNotFoundException extends RuntimeException {
  public BrandNotFoundException() {
    super("Brand not found");
  }
}
