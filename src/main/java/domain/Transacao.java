package main.java.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transacao {

    private TipoTransacao tipo;
    private BigDecimal valor;
    private LocalDateTime data;
    private BigDecimal saldoAposTransacao;

    public Transacao(TipoTransacao tipo, BigDecimal valor, BigDecimal saldoAposTransacao) {
        this.tipo = tipo;
        this.valor = valor;
        this.data = LocalDateTime.now();
        this.saldoAposTransacao = saldoAposTransacao;
    }

    @Override
    public String toString(){
        return tipo +
                " | valor: " + valor +
                " | saldo após: " + saldoAposTransacao +
                " | data: " + data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public TipoTransacao getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }
    
    public BigDecimal getSaldoAposTransacao() {
        return saldoAposTransacao;
    }
}
