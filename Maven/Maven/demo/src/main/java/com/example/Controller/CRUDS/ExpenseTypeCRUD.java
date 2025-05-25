package com.example.Controller.CRUDS;

import java.sql.*;

public class ExpenseTypeCRUD {

    public void readExpenseTypes(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readExpenseTypes()";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("C_Expense_Type") +
                                   ", Description: " + rs.getString("D_Description"));
            }
        }
    }

    public void insertExpenseType(Connection conn, String description) throws SQLException {
        String sql = "{call sp_insertExpenseType(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, description);
            stmt.execute();
        }
    }

    public void updateExpenseType(Connection conn, int id, String description) throws SQLException {
        String sql = "{call sp_updateExpenseType(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, description);
            stmt.execute();
        }
    }

    public void deleteExpenseType(Connection conn, int id) throws SQLException {
        String sql = "{call sp_deleteExpenseType(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}

