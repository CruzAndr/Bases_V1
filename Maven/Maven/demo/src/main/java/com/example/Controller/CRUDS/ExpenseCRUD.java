package com.example.Controller.CRUDS;

import java.sql.*;

public class ExpenseCRUD {

    public void readExpenses(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readExpenses()";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Expense ID: " + rs.getInt("C_Expense") +
                                   ", Amount: " + rs.getBigDecimal("M_Expense_Amount") +
                                   ", Description: " + rs.getString("D_Expense_Description"));
            }
        }
    }

    public void insertExpense(Connection conn, int userId, int accountId, int expenseTypeId, double amount,
                              String description, int categoryId, int transactionTypeId, Timestamp date) throws SQLException {
        String sql = "{call sp_insertExpense(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, accountId);
            stmt.setInt(3, expenseTypeId);
            stmt.setDouble(4, amount);
            stmt.setString(5, description);
            stmt.setInt(6, categoryId);
            stmt.setInt(7, transactionTypeId);
            stmt.setTimestamp(8, date);
            stmt.execute();
        }
    }

    public void updateExpense(Connection conn, int expenseId, int userId, int accountId, int expenseTypeId,
                              double amount, String description) throws SQLException {
        String sql = "{call sp_updateExpense(?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, expenseId);
            stmt.setInt(2, userId);
            stmt.setInt(3, accountId);
            stmt.setInt(4, expenseTypeId);
            stmt.setDouble(5, amount);
            stmt.setString(6, description);
            stmt.execute();
        }
    }

    public void deleteExpense(Connection conn, int expenseId) throws SQLException {
        String sql = "{call sp_deleteExpense(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, expenseId);
            stmt.execute();
        }
    }
}
