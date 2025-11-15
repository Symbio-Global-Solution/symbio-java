package br.com.fiap.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AiResponseDTO {
    // Mapeia o campo JSON
    @JsonProperty("risco_predito")
    private String riscoPredito;

    public String getRiscoPredito() { return riscoPredito; }
    public void setRiscoPredito(String riscoPredito) { this.riscoPredito = riscoPredito; }
}