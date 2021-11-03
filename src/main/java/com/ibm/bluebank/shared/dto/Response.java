package com.ibm.bluebank.shared.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {

    private boolean sucesso;
    private T data;
    private String mensagem;
    private Map<String, String> erros;

    public boolean isSucesso() {
        return sucesso;
    }

    public void setSucesso(boolean sucesso) {
        this.sucesso = sucesso;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Map<String, String> getErros() {
        return erros;
    }

    public void setErros(Map<String, String> erros) {
        this.erros = erros;
    }
}
