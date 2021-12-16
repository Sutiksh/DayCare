package edu.neu.csye6200.utils;

import java.sql.*;
import java.util.Map;
import java.util.Objects;

public class DatabaseUtil {
    static final String RDS_HOSTNAME = "edu-neu-csye6200-daycare-rds-mysql.c3nsipkesvaj.us-east-2.rds.amazonaws.com";
    static final String RDS_PORT = "3306";
    static final String RDS_DB_NAME = "day_care_db";
    static final String RDS_USERNAME = "admin";
    static final String RDS_PASSWORD = "$erac_yad";

    enum DataType {
        STRING,
        BOOLEAN,
        BIG_DECIMAL,
        BYTE,
        SHORT,
        INT,
        LONG,
        FLOAT,
        DOUBLE,
        BYTE_ARR,
        SQL_DATE,
        SQL_TIME,
        SQL_TIMESTAMP,
        SQL_CLOB,
        SQL_BLOB,
        SQL_ARR,
        SQL_REF,
        SQL_STRUCT
    }

    private static String convertDateTypeToStr(DataType type) {
        switch (type) {
            case STRING:
                return "VARCHAR(255)";
            case BOOLEAN:
                return "BIT";
            case BIG_DECIMAL:
                return "NUMERIC";
            case BYTE:
                return "TINYINT";
            case SHORT:
                return "SMALLINT";
            case INT:
                return "INTEGER";
            case LONG:
                return "BIGINT";
            case FLOAT:
                return "FLOAT";
            case DOUBLE:
                return "DOUBLE";
            case BYTE_ARR:
                return "VARBINARY";
            case SQL_DATE:
                return "DATE";
            case SQL_TIME:
                return "TIME";
            case SQL_TIMESTAMP:
                return "TIMESTAMP";
            case SQL_CLOB:
                return "CLOB";
            case SQL_BLOB:
                return "BLOB";
            case SQL_ARR:
                return "ARRAY";
            case SQL_REF:
                return "REF";
            case SQL_STRUCT:
                return "STRUCT";
        }
        return null;
    }

    public static Connection getRemoteConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl =
                    "jdbc:mysql://" + RDS_HOSTNAME + ":" + RDS_PORT + "/" + RDS_DB_NAME + "?user="
                            + RDS_USERNAME + "&password=" + RDS_PASSWORD;
            return DriverManager.getConnection(jdbcUrl);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void createDB(String dbName) {
        try {
            Statement stmt = Objects.requireNonNull(getRemoteConnection()).createStatement();
            stmt.executeUpdate("CREATE DATABASE " + dbName.toUpperCase());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void executeSQL(String sql) {
        try {
            Connection con = getRemoteConnection();
            assert con != null;
            Statement state = con.createStatement();
            state.executeUpdate(sql);

            state.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getTableSize(String tableName) {
        Connection con = DatabaseUtil.getRemoteConnection();
        int size = 0;
        try {
            assert con != null;
            Statement state = con.createStatement();
            String sql = "SELECT COUNT(*) as num FROM " + tableName;
            ResultSet rs = state.executeQuery(sql);
            if(rs.next()){
                size = rs.getInt("num");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return size;
    }

    static void createTable(String tableName, Map<String, DataType> keys, String primaryKey, Map<String, String> foreignKey) {
        try {
            Statement stmt = Objects.requireNonNull(getRemoteConnection()).createStatement();
            StringBuilder sql = new StringBuilder("CREATE TABLE ").append(tableName.toUpperCase()).append(" (\n");

            keys.forEach((k, v) -> sql.append(k).append(" ")
                    .append(convertDateTypeToStr(v)).append(", \n"));

            if (foreignKey != null) {
                foreignKey.forEach((k, v) -> sql.append("FOREIGN KEY (").append(k)
                        .append(") REFERENCES ").append(v).append("(").append(k)
                        .append("), \n"));

            }
            sql.append("PRIMARY KEY ( ").append(primaryKey).append(" ))");

            stmt.executeUpdate(sql.toString());

            System.out.println("[DB] CREATE " + tableName.toUpperCase() + " in " + RDS_DB_NAME);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void createTable(String tableName, Map<String, DataType> keys, String primaryKey) {
        createTable(tableName, keys, primaryKey, null);
    }

    public static void dropTable(String tableName) {
        try {
            Statement stmt = Objects.requireNonNull(getRemoteConnection()).createStatement();
            stmt.executeUpdate("DROP TABLE " + tableName.toUpperCase());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteRecord(String tableName, String primaryKey, String primaryValue) {
        try {
            Statement stmt = Objects.requireNonNull(getRemoteConnection()).createStatement();
            stmt.executeUpdate("DELETE  FROM " + tableName +
                    " WHERE " + primaryKey + " = " + primaryValue);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static ResultSet getSQLResult(String sql){
        try {
            Connection con = DatabaseUtil.getRemoteConnection();

            assert con != null;
            Statement state = con.createStatement();
            ResultSet temp = state.executeQuery(sql);

            state.close();
            con.close();

            return temp;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
