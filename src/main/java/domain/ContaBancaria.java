package main.java.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public abstract class ContaBancaria {

    private static final BigDecimal LIMITE_SAQUE = new BigDecimal("1000");
    private static final BigDecimal LIMITE_DEPOSITO = new BigDecimal("10000");
    private List<Transacao> transacoes = new ArrayList<>();

    private String numeroConta;
    protected BigDecimal saldo;
    private boolean ativa;

    public ContaBancaria (String numeroConta, BigDecimal saldoInicial) {
        this.numeroConta = numeroConta;
        this.saldo = saldoInicial != null ? saldoInicial : BigDecimal.ZERO;
        this.ativa = true;
    }

    public void receberTransferencia(BigDecimal valor){
        validarContaAtiva(); // Sempre validar antes da operação
        validarValor(valor);

        creditar(valor); // realizar operação
        registrarTransacao(TipoTransacao.TRANSFERENCIA_RECEBIDA, valor, saldo); //registrar saldo após operação
    }

    public void depositar(BigDecimal valor) {
        validarContaAtiva();
        validarValor(valor);
        validarLimite(valor, LIMITE_DEPOSITO);

        creditar(valor);
        registrarTransacao(TipoTransacao.DEPOSITO, valor, saldo);
    }

    public abstract void sacar(BigDecimal valor);

    protected void executarSaque(BigDecimal valor){
        validarContaAtiva();
        validarValor(valor);
        validarLimite(valor, LIMITE_SAQUE);
        validarSaldoSuficiente(valor);

        debitar(valor);
        registrarTransacao(TipoTransacao.SAQUE, valor, saldo);
    }

    protected void debitar(BigDecimal valor) {
        saldo = saldo.subtract(valor);
    }

    protected void creditar(BigDecimal valor) {
        saldo = saldo.add(valor);
    }

    protected void validarContaAtiva() {
        if (!ativa) {
            throw new IllegalStateException("Conta Inativa");
        }
    }

    protected void validarValor(BigDecimal valor) {
        if (valor == null || valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor invalido");
        }
    }

    protected void validarSaldoSuficiente(BigDecimal valor) {
        if (valor.compareTo(saldo) > 0) {
            throw new IllegalArgumentException("Saldo insuficiente");
        }
    }

    protected void validarLimite(BigDecimal valor, BigDecimal limite) {
        if (valor.compareTo(limite) > 0) {
            throw new IllegalArgumentException("Valor excede limite por operação");
        }
    }

    protected void registrarTransacao(TipoTransacao tipo, BigDecimal valor, BigDecimal saldoAtual) {
        transacoes.add(new Transacao(tipo, valor, saldoAtual));
    }

    public void estornar (BigDecimal valor) {
        saldo = saldo.add(valor);
    }

    public List<Transacao> getExtrato(){
        return List.copyOf(transacoes);
    }

    public String getNumeroConta() {
        return numeroConta;
    }
    public BigDecimal getSaldo (){
        return saldo;
    }

}
