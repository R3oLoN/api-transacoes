package com.reolon.transacoes.model.transacoes;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.reolon.transacoes.model.accounts.Account;
import com.reolon.transacoes.utils.Database;

@Entity
@Table(name = Transaction.TRANSACTIONS_TABLE_NAME, schema = Database.SCHEMA)
@SequenceGenerator(name = Transaction.TRANSACTIONS_SEQ_NAME, sequenceName = Transaction.TRANSACTIONS_SEQ_NAME, schema = Database.SCHEMA, allocationSize = 1)
public class Transaction {
    public static final String TRANSACTIONS_TABLE_NAME = "VW_TRANSACTIONS";
    public static final String TRANSACTIONS_SEQ_NAME = "SEQ_TRANSACTIONS";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = TRANSACTIONS_SEQ_NAME)
    @Column(name = "ID", updatable = false)
    private Long id;

    @NotNull(message = "A conta da transação é obrigatório.")
    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID", updatable = false)
    private Account conta;

    @NotNull(message = "O tipo da transação é obrigatório.")
    @Column(name = "OPERATION_TYPE", updatable = false)
    private OperationType tipoOperacao;

    @NotNull(message = "O Valor da transação é obrigatório.")
    @Column(name = "VALOR", updatable = false)
    private BigDecimal valor;

    @Column(name = "DH_TRANSACTION", insertable = false, updatable = false)
    private LocalDateTime dhTransacao;

    public Long getId() {
        return this.id;
    }

    public Account getConta() {
        return this.conta;
    }

    public OperationType getTipoOperacao() {
        return this.tipoOperacao;
    }

    public BigDecimal getValor() {
        return this.valor;
    }

    public LocalDateTime getDhTransacao() {
        return this.dhTransacao;
    }

    public static class Builder {
        private final Transaction transaction;

        private Builder(final Transaction transaction) {
            this.transaction = transaction;
        }

        public static Builder create() {
            return new Builder(new Transaction());
        }

        public static Builder from(final Transaction transaction) {
            return new Builder(transaction);
        }

        public Builder id(Long id) {
            this.transaction.id = id;
            return this;
        }

        public Builder conta(Account conta) {
            this.transaction.conta = conta;
            return this;
        }

        public Builder tipoOperacao(OperationType tipoOperacao) {
            this.transaction.tipoOperacao = tipoOperacao;
            return this;
        }

        public Builder valor(BigDecimal valor) {
            this.transaction.valor = valor;
            return this;
        }
    }
}
