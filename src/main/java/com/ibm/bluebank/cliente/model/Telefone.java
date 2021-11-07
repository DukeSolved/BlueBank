package com.ibm.bluebank.cliente.model;

public class Telefone {
    private String   id;
    private String[] ddd;
    private String[] numero;

    private String getId() {return id;}

    private String[] getDdd() {return ddd;}

    private String[] getNumero() {return numero;}

    private void setId(String id) {this.id = id;}

    private void setDdd(String[] ddd) {this.ddd = ddd;}

    private void setNumero(String[] numero) {this.numero = numero;}

//   private String getTelefone(String telefone){
//        if(telefone.length() != 10 && telefone.length() != 11) return telefone;
//        return telefone.length() == 10 ? Util.(telefone) : Util.getTelef9Digitos(telefone);
//   }


}
