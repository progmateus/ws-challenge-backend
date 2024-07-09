package br.com.wschallenge.ws_challenge.domain.modules.cars.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class CreateCarDTO {
    @NotBlank()
    public LocalDateTime timestamp_cadastro;
    @NotBlank()
    public UUID modelo_id;
    @NotBlank()
    public String ano;
    @NotBlank()
    public String combustivel;
    @NotBlank()
    public Integer num_portas;
    @NotBlank()
    public String cor;
}
