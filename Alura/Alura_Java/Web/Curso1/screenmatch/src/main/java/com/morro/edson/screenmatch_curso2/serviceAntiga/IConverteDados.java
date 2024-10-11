package com.morro.edson.screenmatch_curso2.serviceAntiga;

public interface IConverteDados {
    <T> T  obterDados(String json, Class<T> classe);
}
