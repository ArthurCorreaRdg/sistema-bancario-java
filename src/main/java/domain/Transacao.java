package main.java.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Transacao {

    private TipoTransacao tipo;
    private BigDecimal valor;
    private LocalDateTime data;

    public Transacao(TipoTransacao tipo, BigDecimal valor){
        this.tipo = tipo;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    public String getTipo() {
        return tipo;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public LocalDateTime getData() {
        return data;
    }
}
