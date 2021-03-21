--liquibase formatted sql

--changeset leandro.reolon:001 context:dev,test,prod
CREATE TABLE PISMO_OWNER.TRANSACTIONS (
    ID              BIGINT NOT NULL CONSTRAINT PK_TRANSACTIONS PRIMARY KEY,
    ACCOUNT_ID      BIGINT NOT NULL CONSTRAINT FK_ACCOUNTS REFERENCES PISMO_OWNER.ACCOUNTS,
    OPERATION_TYPE  VARCHAR(2) NOT NULL,
    VALOR           DECIMAL(18,4) NOT NULL,
    DH_TRANSACTION  TIMESTAMP(6) DEFAULT NOW()
);
--rollback DROP TABLE PISMO_OWNER.TRANSACTIONS;

--changeset leandro.reolon:002 context:dev,test,prod
COMMENT ON TABLE PISMO_OWNER.TRANSACTIONS IS 'Transactions';
COMMENT ON COLUMN PISMO_OWNER.TRANSACTIONS.ID IS 'Código da transação';
COMMENT ON COLUMN PISMO_OWNER.TRANSACTIONS.ACCOUNT_ID IS 'Código da conta';
COMMENT ON COLUMN PISMO_OWNER.TRANSACTIONS.OPERATION_TYPE IS 'Tipo de operação';
COMMENT ON COLUMN PISMO_OWNER.TRANSACTIONS.VALOR IS 'Valor da transação';
COMMENT ON COLUMN PISMO_OWNER.TRANSACTIONS.DH_TRANSACTION IS 'Data e hora da transação';
--rollback not required;

--changeset leandro.reolon:003 context:dev,test,prod
CREATE SEQUENCE PISMO_OWNER.SEQ_TRANSACTIONS MAXVALUE 9999999999 CACHE 1;
--rollback DROP SEQUENCE PISMO_OWNER.SEQ_TRANSACTIONS;

--changeset leandro.reolon:004 context:dev,test,prod
ALTER TABLE PISMO_OWNER.TRANSACTIONS ALTER COLUMN ID SET DEFAULT NEXTVAL('PISMO_OWNER.SEQ_TRANSACTIONS');
--rollback ALTER TABLE PISMO_OWNER.TRANSACTIONS ALTER COLUMN ID DROP DEFAULT;

--changeset leandro.reolon:005 context:dev,test,prod
CREATE INDEX IDX_TRANSACTIONS__ACCOUNT_ID ON PISMO_OWNER.TRANSACTIONS (ACCOUNT_ID);
--rollback DROP INDEX PISMO_OWNER.IDX_TRANSACTIONS__ACCOUNT_ID;

--changeset leandro.reolon:006 context:dev,test,prod
CREATE VIEW PISMO_OWNER.VW_TRANSACTIONS AS SELECT * FROM PISMO_OWNER.TRANSACTIONS;
--rollback DROP VIEW PISMO_OWNER.VW_TRANSACTIONS;

--changeset leandro.reolon:007 context:dev,test,prod
GRANT SELECT ON PISMO_OWNER.VW_TRANSACTIONS TO PISMO_READ;
GRANT SELECT, INSERT, UPDATE, DELETE ON PISMO_OWNER.VW_TRANSACTIONS TO PISMO_SYSTEM;
GRANT ALL ON SEQUENCE PISMO_OWNER.SEQ_TRANSACTIONS TO PISMO_SYSTEM;
--rollback not required
