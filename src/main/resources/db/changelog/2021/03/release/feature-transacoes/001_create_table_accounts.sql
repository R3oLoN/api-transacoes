--liquibase formatted sql

--changeset leandro.reolon:001 context:dev,test,prod
CREATE TABLE PISMO_OWNER.ACCOUNTS (
    ID         BIGINT NOT NULL CONSTRAINT PK_ACCOUNTS PRIMARY KEY,
    DOCUMENTO  VARCHAR(14)
);
--rollback DROP TABLE PISMO_OWNER.ACCOUNTS;

--changeset leandro.reolon:002 context:dev,test,prod
COMMENT ON TABLE PISMO_OWNER.ACCOUNTS IS 'Accounts';
COMMENT ON COLUMN PISMO_OWNER.ACCOUNTS.ID IS 'Código';
COMMENT ON COLUMN PISMO_OWNER.ACCOUNTS.DOCUMENTO IS 'Número do documento';
--rollback not required;

--changeset leandro.reolon:003 context:dev,test,prod
CREATE SEQUENCE PISMO_OWNER.SEQ_ACCOUNTS MAXVALUE 9999999999 CACHE 1;
--rollback DROP SEQUENCE PISMO_OWNER.SEQ_ACCOUNTS;

--changeset leandro.reolon:004 context:dev,test,prod
ALTER TABLE PISMO_OWNER.ACCOUNTS ALTER COLUMN ID SET DEFAULT NEXTVAL('PISMO_OWNER.SEQ_ACCOUNTS');
--rollback ALTER TABLE PISMO_OWNER.ACCOUNTS ALTER COLUMN ID DROP DEFAULT;

--changeset leandro.reolon:005 context:dev,test,prod
CREATE VIEW PISMO_OWNER.VW_ACCOUNTS AS SELECT * FROM PISMO_OWNER.ACCOUNTS;
--rollback DROP VIEW PISMO_OWNER.VW_ACCOUNTS;

--changeset leandro.reolon:006 context:dev,test,prod
GRANT SELECT ON PISMO_OWNER.ACCOUNTS TO PISMO_READ;
GRANT SELECT, INSERT, UPDATE, DELETE ON PISMO_OWNER.ACCOUNTS TO PISMO_SYSTEM;
--rollback not required