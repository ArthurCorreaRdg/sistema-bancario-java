package main.java.domain;

import java.math.BigDecimal;

public class ContaCorrente extends ContaBancaria {

    public static final BigDecimal TAXA_SAQUE = new BigDecimal("5");

    public ContaCorrente(String numeroConta, BigDecimal saldoInicial) {
        super(numeroConta, saldoInicial);
    }

    @Override
    public void sacar(BigDecimal valor) {
        BigDecimal valorComTaxa = valor.add(TAXA_SAQUE);

        executarSaque(valorComTaxa);
    }
}
