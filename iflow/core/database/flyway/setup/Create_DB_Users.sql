
-- Change code page in console: chcp 1252

--/**
-- * During (re-)creation of the MDMDB and/or TASKDB the user "root" is connected to the always present database named "postgres".
-- */

DROP DATABASE IF EXISTS @mdm.module.db.database@;

DROP USER IF EXISTS @mdm.module.db.user@;

CREATE USER @mdm.module.db.user@ WITH 
    LOGIN
    NOBYPASSRLS
    PASSWORD '@mdm.module.db.user.password@'
    ;


DROP USER IF EXISTS @mdm.module.db.owner@;

CREATE USER @mdm.module.db.owner@ WITH 
    LOGIN
    NOBYPASSRLS
    PASSWORD '@mdm.module.db.owner.password@'
    ;

GRANT @mdm.module.db.owner@ TO root;

CREATE DATABASE @mdm.module.db.database@ WITH 
    OWNER @mdm.module.db.owner@
    TEMPLATE template0
    ENCODING 'UTF8'
    ;

GRANT SELECT, INSERT, UPDATE, DELETE ON ALL TABLES IN SCHEMA PUBLIC TO @mdm.module.db.user@;
