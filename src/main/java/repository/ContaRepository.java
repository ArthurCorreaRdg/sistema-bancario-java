package main.java.repository;

import main.java.domain.ContaBancaria;

public interface ContaRepository {
    ContaBancaria buscaPorNumero(String numero);
    void salvar(ContaBancaria conta);
}
