package com.example.Controller.CRUDS;

import java.sql.*;

public class DebtCRUD {

    public void readDebts(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readDebts()";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Debt ID: " + rs.getInt("C_Debt") +
                                   ", Amount: " + rs.getBigDecimal("M_Amount") +
                                   ", Status: " + rs.getString("T_Debt_Status"));
            }
        }
    }

    public void insertDebt(Connection conn, int userId, int accountId, int creditorId, int debtTypeId,
                           String status, double amount, double interest, double remaining,
                           Timestamp startDate, Timestamp dueDate, String collateral,
                           int categoryId, int transactionTypeId) throws SQLException {
        String sql = "{call sp_insertDebt(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, accountId);
            stmt.setInt(3, creditorId);
            stmt.setInt(4, debtTypeId);
            stmt.setString(5, status);
            stmt.setDouble(6, amount);
            stmt.setDouble(7, interest);
            stmt.setDouble(8, remaining);
            stmt.setTimestamp(9, startDate);
            stmt.setTimestamp(10, dueDate);
            stmt.setString(11, collateral);
            stmt.setInt(12, categoryId);
            stmt.setInt(13, transactionTypeId);
            stmt.execute();
        }
    }

    public void updateDebt(Connection conn, int debtId, int userId, int accountId, int creditorId, int debtTypeId,
                           String status, double amount, double interest, double remaining,
                           Timestamp startDate, Timestamp dueDate, String collateral) throws SQLException {
        String sql = "{call sp_updateDebt(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, debtId);
            stmt.setInt(2, userId);
            stmt.setInt(3, accountId);
            stmt.setInt(4, creditorId);
            stmt.setInt(5, debtTypeId);
            stmt.setString(6, status);
            stmt.setDouble(7, amount);
            stmt.setDouble(8, interest);
            stmt.setDouble(9, remaining);
            stmt.setTimestamp(10, startDate);
            stmt.setTimestamp(11, dueDate);
            stmt.setString(12, collateral);
            stmt.execute();
        }
    }

    public void deleteDebt(Connection conn, int debtId) throws SQLException {
        String sql = "{call sp_deleteDebt(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, debtId);
            stmt.execute();
        }
    }
}
