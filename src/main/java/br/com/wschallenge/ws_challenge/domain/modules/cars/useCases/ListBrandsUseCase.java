package br.com.wschallenge.ws_challenge.domain.modules.cars.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.wschallenge.ws_challenge.data.modules.cars.repositories.BrandRepository;
import br.com.wschallenge.ws_challenge.domain.modules.cars.entities.BrandEntity;

@Service
public class ListBrandsUseCase {
  @Autowired
  BrandRepository brandRepository;

  public List<BrandEntity> execute(String params) {
    return this.brandRepository.findByNomeContaining(params);
  }
}
