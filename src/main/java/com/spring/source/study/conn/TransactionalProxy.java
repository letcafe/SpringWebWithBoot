package com.spring.source.study.conn;

import java.sql.*;

public class TransactionalProxy implements IFace{

    private String a;
    private String b;
    private String c;
    private String d;

    protected String a1;
    protected String b1;
    protected String c1;

    public static void main(String[] args) throws SQLException {
        MyDemo myDemo = new MyDemo();
        System.out.println(myDemo instanceof IFace);
    }

    public void printSQLResult(Connection connection, String sql) throws SQLException {
        PreparedStatement pstmt = connection.prepareStatement(sql);
        int re = pstmt.executeUpdate();
        System.out.println("[PSTMT result] = " + re);
        throw new SQLException("DB error");
    }
}


interface IFace {
    void printSQLResult(Connection connection, String sql) throws SQLException;
}

class MyDemo implements IFace {

    @Override
    public void printSQLResult(Connection connection, String sql) throws SQLException {

    }
}

