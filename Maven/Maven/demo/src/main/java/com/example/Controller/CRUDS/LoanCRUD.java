package com.example.Controller.CRUDS;

import java.sql.*;

public class LoanCRUD {

    public void readLoans(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readLoans()";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("Loan ID: " + rs.getInt("C_Loan") +
                                   ", Amount: " + rs.getBigDecimal("M_Loan_Amount") +
                                   ", Status: " + rs.getString("T_Loan_Status"));
            }
        }
    }

    public void insertLoan(Connection conn, int userId, int accountId, int creditorId, int loanTypeId,
                           String status, double amount, double interest,
                           Timestamp startDate, Timestamp dueDate, String collateral,
                           int categoryId, int transactionTypeId) throws SQLException {
        String sql = "{call sp_insertLoan(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, userId);
            stmt.setInt(2, accountId);
            stmt.setInt(3, creditorId);
            stmt.setInt(4, loanTypeId);
            stmt.setString(5, status);
            stmt.setDouble(6, amount);
            stmt.setDouble(7, interest);
            stmt.setTimestamp(8, startDate);
            stmt.setTimestamp(9, dueDate);
            stmt.setString(10, collateral);
            stmt.setInt(11, categoryId);
            stmt.setInt(12, transactionTypeId);
            stmt.execute();
        }
    }

    public void updateLoan(Connection conn, int loanId, int userId, int accountId, int creditorId, int loanTypeId,
                           String status, double amount, double interest,
                           Timestamp startDate, Timestamp dueDate, String collateral) throws SQLException {
        String sql = "{call sp_updateLoan(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, loanId);
            stmt.setInt(2, userId);
            stmt.setInt(3, accountId);
            stmt.setInt(4, creditorId);
            stmt.setInt(5, loanTypeId);
            stmt.setString(6, status);
            stmt.setDouble(7, amount);
            stmt.setDouble(8, interest);
            stmt.setTimestamp(9, startDate);
            stmt.setTimestamp(10, dueDate);
            stmt.setString(11, collateral);
            stmt.execute();
        }
    }

    public void deleteLoan(Connection conn, int loanId) throws SQLException {
        String sql = "{call sp_deleteLoan(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, loanId);
            stmt.execute();
        }
    }
}

