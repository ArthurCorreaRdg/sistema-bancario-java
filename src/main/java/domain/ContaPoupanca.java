package main.java.domain;

import java.math.BigDecimal;

public class ContaPoupanca extends ContaBancaria{

    private static final BigDecimal TAXA_RENDIMENTO = new BigDecimal("0.005");

    public ContaPoupanca(String numeroConta, BigDecimal saldoInicial) {
        super(numeroConta, saldoInicial);
    }

    @Override
    public void sacar(BigDecimal valor) {
        executarSaque(valor);
    }

    public void render (){
        BigDecimal rendimento = saldo.multiply(TAXA_RENDIMENTO);
        creditar(rendimento);
    }
}
