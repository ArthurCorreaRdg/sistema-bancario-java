package main.java.service;

import main.java.domain.ContaBancaria;
import java.math.BigDecimal;

public class ContaService {

    public void depositar (ContaBancaria conta, BigDecimal valor){
        if (conta == null){
            throw new IllegalStateException("Conta não pode ser nula");
        }
        conta.depositar(valor);
    }

    public void sacar (ContaBancaria conta, BigDecimal valor){
        conta.sacar(valor);
    }

    public void transferir (ContaBancaria origem, ContaBancaria destino, BigDecimal valor) {

        try {
            origem.sacar(valor);
            destino.receberTransferencia(valor);
        } catch (Exception e) {
            origem.estornar(valor);
            throw new RuntimeException("Erro na transferência. Operação revertida");
        }
    }

}
