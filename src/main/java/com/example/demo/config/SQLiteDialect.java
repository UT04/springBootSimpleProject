package com.example.demo.config;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.IdentityColumnSupport;
import org.hibernate.dialect.identity.IdentityColumnSupportImpl;
import org.hibernate.dialect.sequence.NoSequenceSupport;
import org.hibernate.dialect.sequence.SequenceSupport;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;
import org.hibernate.engine.jdbc.env.spi.NameQualifierSupport;

import java.sql.Types;

public class SQLiteDialect extends Dialect {

    public SQLiteDialect() {
        super();
    }

    public SQLiteDialect(DialectResolutionInfo info) {
        super(info);
    }

    @Override
    public IdentityColumnSupport getIdentityColumnSupport() {
        return new IdentityColumnSupportImpl() {
            
            public String getIdentitySelectString() {
                return "select last_insert_rowid()";
            }

            
            public String getIdentityColumnString() {
                return "integer not null primary key autoincrement";
            }

            
            public boolean supportsIdentityColumns() {
                return true;
            }
        };
    }

    @Override
    public SequenceSupport getSequenceSupport() {
        return NoSequenceSupport.INSTANCE;
    }

 
    public String getIdentifierQuoteString() {
        return "\"";
    }

    @Override
    public NameQualifierSupport getNameQualifierSupport() {
        return NameQualifierSupport.NONE;
    }

    @Override
    public boolean supportsCurrentTimestampSelection() {
        return false;
    }

    @Override
    public boolean isCurrentTimestampSelectStringCallable() {
        return false;
    }

    @Override
    public String getCurrentTimestampSelectString() {
        return "";
    }

    @Override
    protected String columnType(int sqlTypeCode) {
        if (sqlTypeCode == Types.BOOLEAN) {
            return "integer";
        }
        return super.columnType(sqlTypeCode);
    }

    @Override
    protected String castType(int sqlTypeCode) {
        if (sqlTypeCode == Types.BOOLEAN) {
            return "integer";
        }
        return super.castType(sqlTypeCode);
    }
}
