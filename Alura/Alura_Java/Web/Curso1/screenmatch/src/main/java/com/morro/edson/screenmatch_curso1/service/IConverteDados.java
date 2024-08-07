package com.morro.edson.screenmatch_curso1.service;

public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe);
}
