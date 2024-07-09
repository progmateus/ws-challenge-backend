package br.com.wschallenge.ws_challenge.domain.modules.cars.entities;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "models")
public class ModelEntity {
  @Id()
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne()
  @JoinColumn(name = "marca_id", insertable = false, updatable = false)
  private BrandEntity marcaEntity;

  @NotNull()
  private UUID marca_id;

  @Length(min = 3, max = 80)

  private String nome;

  private Float valor_flipe;

  public void Update(ModelEntity data) {
    this.marca_id = data.marca_id;
    this.nome = data.nome;
    this.nome = data.nome;
    this.valor_flipe = data.valor_flipe;
  }
}
