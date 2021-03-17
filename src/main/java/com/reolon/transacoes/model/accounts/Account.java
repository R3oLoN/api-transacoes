package com.reolon.transacoes.model.accounts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.reolon.transacoes.utils.Database;

@Entity
@Table(name = Account.ACCOUNTS_TABLE_NAME, schema = Database.SCHEMA)
@SequenceGenerator(name = Account.ACCOUNTS_SEQ_NAME, sequenceName = Account.ACCOUNTS_SEQ_NAME, schema = Database.SCHEMA, allocationSize = 1)
public class Account {
    public static final String ACCOUNTS_TABLE_NAME = "VW_ACCOUNTS";
    public static final String ACCOUNTS_SEQ_NAME = "SEQ_ACCOUNTS";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = ACCOUNTS_SEQ_NAME)
    @Column(name = "ID", updatable = false)
    private Long id;

    @NotNull(message = "O documento da conta é obrigatório.")
    @Column(name = "DOCUMENTO", nullable = false)
    private String documento;

    public Long getId() {
        return id;
    }

    public String getDocumento() {
        return documento;
    }

    public static class Builder {
        private final Account account;

        private Builder(final Account account) {
            this.account = account;
        }

        public static Builder create() {
            return new Builder(new Account());
        }

        public static Builder from(final Account account) {
            return new Builder(account);
        }

        public Builder id(Long id) {
            this.account.id = id;
            return this;
        }

        public Builder documento(String documento) {
            this.account.documento = documento;
            return this;
        }
    }
}
