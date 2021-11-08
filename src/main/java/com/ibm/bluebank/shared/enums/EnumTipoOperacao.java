package com.ibm.bluebank.shared.enums;

public enum EnumTipoOperacao {
    SAQUE(true, false, true),
    DEPOSITO(false, true, false),
    TRANSFERENCIA(true, true, true);

    private Boolean contaOperacaoObrigatoria;
    private Boolean contaDestinoObrigatoria;
    private Boolean validarSaldo;

    private EnumTipoOperacao(Boolean contaOperacaoObrigatoria, Boolean contaDestinoObrigatoria, Boolean validarSaldo) {
        this.contaOperacaoObrigatoria = contaOperacaoObrigatoria;
        this.contaDestinoObrigatoria = contaDestinoObrigatoria;
        this.validarSaldo = validarSaldo;
    }

    public Boolean getContaOperacaoObrigatoria() {
        return contaOperacaoObrigatoria;
    }

    public Boolean getContaDestinoObrigatoria() {
        return contaDestinoObrigatoria;
    }

    public Boolean getValidarSaldo() {
        return validarSaldo;
    }
}
