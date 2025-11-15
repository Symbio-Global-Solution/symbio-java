package br.com.fiap.dto;

public class AiRequestDTO {
    private int[] features;

    public AiRequestDTO() {}

    public AiRequestDTO(int[] features) {
        this.features = features;
    }

    public int[] getFeatures() { return features; }
    public void setFeatures(int[] features) { this.features = features; }
}