package br.com.pedro.models;

import java.math.BigDecimal;

public class Conta {
    private Integer numero;
    private String senha;
    private BigDecimal saldo;
//    private boolean bloqueado;

    public Conta(Integer numero, String senha, BigDecimal saldo) {
        this.numero = numero;
        this.senha = senha;
        this.saldo = saldo;
    }

    public Integer getNumero() {
        return this.numero;
    }

    public String getSenha() {
        return this.senha;
    }

    public BigDecimal setSaldo(BigDecimal saldo) {
        return this.saldo = saldo;
    }

    public BigDecimal getSaldo() {
        return this.saldo;
    }

    @Override
    public String toString() {
        return "Número da conta: " + this.numero + ", Saldo: R$" + this.saldo;
    }
}
