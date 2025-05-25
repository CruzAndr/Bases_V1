package com.example.Controller.CRUDS;

import java.sql.*;

public class TransactionCRUD {

    public void readTransactions(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readTransactions()";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Transaction ID: " + rs.getInt("C_Transaction") +
                                   ", User: " + rs.getInt("C_User") +
                                   ", Amount: " + rs.getBigDecimal("M_Amount") +
                                   ", Description: " + rs.getString("D_Transaction_Description"));
            }
        }
    }

    public void insertTransaction(Connection conn, int userId, int accountId, int categoryId, int typeId,
                                  double amount, String description, Timestamp date) throws SQLException {
        String sql = "{call sp_insertTransaction(?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, accountId);
            stmt.setInt(3, categoryId);
            stmt.setInt(4, typeId);
            stmt.setDouble(5, amount);
            stmt.setString(6, description);
            stmt.setTimestamp(7, date);
            stmt.execute();
        }
    }

    public void deleteTransaction(Connection conn, int transactionId) throws SQLException {
        String sql = "{call sp_deleteTransaction(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, transactionId);
            stmt.execute();
        }
    }

    public void updateTransaction(Connection conn, int transactionId, int userId, int accountId, int categoryId,
                                  int typeId, double amount, String description, Timestamp date) throws SQLException {
        String sql = "{call sp_updateTransaction(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, transactionId);
            stmt.setInt(2, userId);
            stmt.setInt(3, accountId);
            stmt.setInt(4, categoryId);
            stmt.setInt(5, typeId);
            stmt.setDouble(6, amount);
            stmt.setString(7, description);
            stmt.setTimestamp(8, date);
            stmt.execute();
        }
    }
}
