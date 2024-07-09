package br.com.wschallenge.ws_challenge.domain.modules.cars.entities;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity(name = "brands")
public class BrandEntity {
  @Id()
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @Length(min = 3, max = 80)
  private String nome;

  public void Update(BrandEntity data) {
    this.nome = data.nome;
  }
}
