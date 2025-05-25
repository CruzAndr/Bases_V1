package com.example.Controller.CRUDS;

import java.sql.*;

public class IncomeCRUD {

    public void readIncomes(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readIncomes()";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Income ID: " + rs.getInt("C_Income") +
                                   ", Amount: " + rs.getBigDecimal("M_Income_Amount") +
                                   ", Description: " + rs.getString("D_Income_Description"));
            }
        }
    }

    public void insertIncome(Connection conn, int userId, int accountId, int incomeTypeId, double amount,
                              String description, Timestamp date, int categoryId, int transactionTypeId) throws SQLException {
        String sql = "{call sp_insertIncome(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, accountId);
            stmt.setInt(3, incomeTypeId);
            stmt.setDouble(4, amount);
            stmt.setString(5, description);
            stmt.setTimestamp(6, date);
            stmt.setInt(7, categoryId);
            stmt.setInt(8, transactionTypeId);
            stmt.execute();
        }
    }

    public void updateIncome(Connection conn, int incomeId, int userId, int accountId, int incomeTypeId,
                              double amount, String description, Timestamp date) throws SQLException {
        String sql = "{call sp_updateIncome(?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, incomeId);
            stmt.setInt(2, userId);
            stmt.setInt(3, accountId);
            stmt.setInt(4, incomeTypeId);
            stmt.setDouble(5, amount);
            stmt.setString(6, description);
            stmt.setTimestamp(7, date);
            stmt.execute();
        }
    }

    public void deleteIncome(Connection conn, int incomeId) throws SQLException {
        String sql = "{call sp_deleteIncome(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, incomeId);
            stmt.execute();
        }
    }
}
