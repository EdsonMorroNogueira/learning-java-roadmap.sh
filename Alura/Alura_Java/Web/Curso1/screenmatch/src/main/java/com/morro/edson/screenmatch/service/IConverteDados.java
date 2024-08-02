package com.morro.edson.screenmatch.service;

public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe);
}
