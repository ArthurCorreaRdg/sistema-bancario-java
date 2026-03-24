package main.java.domain;

import java.math.BigDecimal;

public class ContaSalario extends ContaBancaria{

    public ContaSalario(String numeroConta, BigDecimal saldoInicial){
        super(numeroConta, saldoInicial);
    }

    @Override
    public void depositar(BigDecimal valor) {
        throw new UnsupportedOperationException("Conta salário não recebe deposito direto.");
    }

    @Override
    public void sacar(BigDecimal valor) {
        executarSaque(valor);
    }
}
