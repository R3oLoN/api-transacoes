--liquibase formatted sql

--changeset leandro.reolon:001 context:dev,test,prod
CREATE SCHEMA PISMO_OWNER;
--rollback DROP SCHEMA PISMO_OWNER;

--changeset leandro.reolon:002 context:dev,test,prod
SET lock_timeout = 0;
--rollback not required

--changeset leandro.reolon:003 context:dev,test,prod
SET idle_in_transaction_session_timeout = 0;
--rollback not required

--changeset leandro.reolon:004 context:dev,test,prod
SET client_encoding = 'UTF8';
--rollback not required

--changeset leandro.reolon:005 context:dev,test,prod
SET standard_conforming_strings = on;
--rollback not required

--changeset leandro.reolon:006 context:dev,test,prod
SET check_function_bodies = false;
--rollback not required

--changeset leandro.reolon:007 context:dev,test,prod
SET client_min_messages = warning;
--rollback not required

--changeset leandro.reolon:008 context:dev,test,prod
SET row_security = off;
--rollback not required

--changeset leandro.reolon:009 context:dev,test,prod
CREATE USER pismo_system WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION
  PASSWORD 'pismo_system' ;
ALTER USER pismo_system CREATEROLE;
--rollback DROP USER pismo_system;

--changeset leandro.reolon:010 context:dev,test,prod
GRANT USAGE ON SCHEMA PISMO_OWNER TO  pismo_system;
--rollback REVOKE USAGE ON SCHEMA PISMO_OWNER FROM pismo_system;

--changeset leandro.reolon:011 context:dev,test,prod
CREATE USER pismo_read WITH
  LOGIN
  NOSUPERUSER
  INHERIT
  NOCREATEDB
  NOCREATEROLE
  NOREPLICATION
  PASSWORD 'pismo_read' ;
ALTER USER pismo_read CREATEROLE;
--rollback DROP USER pismo_read;

--changeset leandro.reolon:012 context:dev,test,prod
GRANT USAGE ON SCHEMA PISMO_OWNER TO  pismo_read;
--rollback REVOKE USAGE ON SCHEMA PISMO_OWNER FROM pismo_read;

--changeset leandro.reolon:013 context:test
ALTER USER pismo_system WITH PASSWORD '&faF32h9TRxLgL';
--rollback not required

--changeset leandro.reolon:014 context:prod
ALTER USER pismo_system WITH PASSWORD 'jABxqok2hA@BP7';
--rollback not required

--changeset leandro.reolon:015 context:test
ALTER USER pismo_read WITH PASSWORD 'bK82JghR&WHULo';
--rollback not required

--changeset leandro.reolon:016 context:prod
ALTER USER pismo_read WITH PASSWORD '548p2vfzGH2xGn';
--rollback not required
