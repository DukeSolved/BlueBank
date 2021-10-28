package com.ibm.bluebank.rest.dto;

public class Response<T> {

    private boolean sucesso;
    private T data;

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
}
