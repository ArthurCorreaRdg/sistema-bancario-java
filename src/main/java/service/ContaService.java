package main.java.service;

import main.java.domain.ContaBancaria;

import java.math.BigDecimal;

public class ContaService {

    public void transferir (ContaBancaria origem, ContaBancaria destino, BigDecimal valor) {
        origem.sacar(valor);
        destino.depositar(valor);
    }

}
