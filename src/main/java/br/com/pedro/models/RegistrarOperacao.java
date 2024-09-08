package br.com.pedro.models;

import java.math.BigDecimal;
import java.time.LocalDate;

public class RegistrarOperacao {
    private String tipoDaOperacao;
    private Number numeroDaConta;
    private BigDecimal valor;
    private LocalDate data;

    public RegistrarOperacao(String tipoDaOperacao, Number numeroDaConta, BigDecimal valor, LocalDate data) {
        this.tipoDaOperacao = tipoDaOperacao;
        this.numeroDaConta = numeroDaConta;
        this.valor = valor;
        this.data = data;
    }

    @Override
    public String toString() {
        return tipoDaOperacao + " - Número da Conta: " + numeroDaConta + " - R$" + valor + " - Data da Operação: " + data + "\n";
    }
}
