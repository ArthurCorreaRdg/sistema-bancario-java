package main.java;

import main.java.domain.*;
import main.java.service.ContaService;

import java.math.BigDecimal;

public class app {
    public static void main(String[] args) {

        ContaService service = new ContaService();

        ContaBancaria conta1 = new ContaCorrente("123", new BigDecimal("1000"));
        ContaBancaria conta2 = new ContaCorrente("456", new BigDecimal("500"));

        // TESTE DEPÓSITO
        service.depositar(conta1, new BigDecimal("200"));

        // TESTE SAQUE
        service.sacar(conta1, new BigDecimal("100"));

        // TESTE TRANSFERÊNCIA
        service.transferir(conta1, conta2, new BigDecimal("300"));

        // EXIBIR RESULTADOS
        System.out.println("Saldo Conta 1: " + conta1.getSaldo());
        System.out.println("Saldo Conta 2: " + conta2.getSaldo());

        // EXTRATO
        System.out.println("\nExtrato Conta 1:");
        conta1.getExtrato().forEach(System.out::println);

        System.out.println("\nExtrato Conta 2:");
        conta2.getExtrato().forEach(System.out::println);
    }
}