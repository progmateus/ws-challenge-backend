package br.com.wschallenge.ws_challenge.domain.modules.cars.entities;

import java.time.LocalDateTime;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import br.com.wschallenge.ws_challenge.domain.modules.cars.dtos.CreateCarDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity(name = "cars")
public class CarEntity {
  @Id()
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;

  @ManyToOne()
  @JoinColumn(name = "modelo_id", referencedColumnName = "id", insertable = false, updatable = false)
  private ModelEntity modeloEntity;

  @NotNull()
  private UUID modelo_id;

  @Length(min = 4, max = 4)
  private String ano;

  @Length(min = 3, max = 80)
  private String combustivel;

  private Integer num_portas;

  @Length(min = 3, max = 80)
  private String cor;

  @CreationTimestamp
  private LocalDateTime timestamp_cadastro;

  public void Update(CarEntity data) {
    this.modelo_id = data.modelo_id;
    this.ano = data.ano;
    this.combustivel = data.combustivel;
    this.num_portas = data.num_portas;
    this.cor = data.cor;
  }
}
