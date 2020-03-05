package com.pth.iflow.gui.dal.helper;

import java.sql.Types;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.function.SQLFunctionTemplate;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.dialect.function.VarArgsSQLFunction;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.type.StringType;

public class SQLiteDialect extends Dialect {

  public SQLiteDialect() {

    this.registerColumnType(Types.BIT, "integer");
    this.registerColumnType(Types.TINYINT, "tinyint");
    this.registerColumnType(Types.SMALLINT, "smallint");
    this.registerColumnType(Types.INTEGER, "integer");
    this.registerColumnType(Types.BIGINT, "bigint");
    this.registerColumnType(Types.FLOAT, "float");
    this.registerColumnType(Types.REAL, "real");
    this.registerColumnType(Types.DOUBLE, "double");
    this.registerColumnType(Types.NUMERIC, "numeric");
    this.registerColumnType(Types.DECIMAL, "decimal");
    this.registerColumnType(Types.CHAR, "char");
    this.registerColumnType(Types.VARCHAR, "varchar");
    this.registerColumnType(Types.LONGVARCHAR, "longvarchar");
    this.registerColumnType(Types.DATE, "date");
    this.registerColumnType(Types.TIME, "time");
    this.registerColumnType(Types.TIMESTAMP, "timestamp");
    this.registerColumnType(Types.BINARY, "blob");
    this.registerColumnType(Types.VARBINARY, "blob");
    this.registerColumnType(Types.LONGVARBINARY, "blob");
    // registerColumnType(Types.NULL, "null");
    this.registerColumnType(Types.BLOB, "blob");
    this.registerColumnType(Types.CLOB, "clob");
    this.registerColumnType(Types.BOOLEAN, "integer");

    this.registerFunction("concat", new VarArgsSQLFunction(StringType.INSTANCE, "", "||", ""));
    this.registerFunction("mod", new SQLFunctionTemplate(StringType.INSTANCE, "?1 % ?2"));
    this.registerFunction("substr", new StandardSQLFunction("substr", StringType.INSTANCE));
    this.registerFunction("substring", new StandardSQLFunction("substr", StringType.INSTANCE));
  }

  @Override
  public IdentityColumnSupport getIdentityColumnSupport() {

    return new SQLiteIdentityColumnSupport();
  }

  @Override
  public boolean hasAlterTable() {

    return false;
  }

  @Override
  public boolean dropConstraints() {

    return false;
  }

  @Override
  public String getDropForeignKeyString() {

    return "";
  }

  @Override
  public String getAddForeignKeyConstraintString(final String cn,
      final String[] fk, final String t, final String[] pk, final boolean rpk) {

    return "";
  }

  @Override
  public String getAddPrimaryKeyConstraintString(final String constraintName) {

    return "";
  }
}
