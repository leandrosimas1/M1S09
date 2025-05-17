package br.senai.futurodev.exercicio.M1S09.erros;

public record ErrorResponseDto(String code, String message, String cause, String exceptionClassName) {
}
