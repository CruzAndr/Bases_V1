package com.example.Controller.CRUDS;


import java.sql.*;

public class AccountCRUD {

    public void readAccounts(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readAccounts()";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("C_Account") +
                                   ", Name: " + rs.getString("D_Account_Name") +
                                   ", Balance: " + rs.getBigDecimal("M_Current_Balance"));
            }
        }
    }

    public void insertAccount(Connection conn, int userId, String name,
                              double initialAmount, double currentBalance,
                              String status) throws SQLException {
        String sql = "{call sp_insertAccount(?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            stmt.setString(2, name);
            stmt.setBigDecimal(3, new java.math.BigDecimal(initialAmount));
            stmt.setBigDecimal(4, new java.math.BigDecimal(currentBalance));
            stmt.setString(5, status);
            stmt.execute();
        }
    }

    public void updateAccount(Connection conn, int accountId, String name,
                              double initialAmount, double currentBalance,
                              String status) throws SQLException {
        String sql = "{call sp_updateAccount(?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, accountId);
            stmt.setString(2, name);
            stmt.setBigDecimal(3, new java.math.BigDecimal(initialAmount));
            stmt.setBigDecimal(4, new java.math.BigDecimal(currentBalance));
            stmt.setString(5, status);
            stmt.execute();
        }
    }

    public void deleteAccount(Connection conn, int accountId) throws SQLException {
        String sql = "{call sp_deleteAccount(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, accountId);
            stmt.execute();
        }
    }
}

