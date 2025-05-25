package com.example.Controller.CRUDS;

import java.sql.*;

public class TransactionCategoryCRUD {

    public void readTransactionCategories(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readTransactionCategories()";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("C_Transaction_Category") +
                                   ", Name: " + rs.getString("D_Category_Name") +
                                   ", Type: " + rs.getString("T_Category_Type"));
            }
        }
    }

    public void insertTransactionCategory(Connection conn, String name, String description, String type) throws SQLException {
        String sql = "{call sp_insertTransactionCategory(?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, description);
            stmt.setString(3, type);
            stmt.execute();
        }
    }

    public void updateTransactionCategory(Connection conn, int id, String name, String description, String type) throws SQLException {
        String sql = "{call sp_updateTransactionCategory(?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, description);
            stmt.setString(4, type);
            stmt.execute();
        }
    }

    public void deleteTransactionCategory(Connection conn, int id) throws SQLException {
        String sql = "{call sp_deleteTransactionCategory(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
