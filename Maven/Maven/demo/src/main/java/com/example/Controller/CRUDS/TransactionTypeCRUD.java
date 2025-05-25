package com.example.Controller.CRUDS;

import java.sql.*;

public class TransactionTypeCRUD {

    public void readTransactionTypes(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readTransactionTypes()";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("C_Transaction_Type") +
                                   ", Name: " + rs.getString("D_Transaction_Name"));
            }
        }
    }

    public void insertTransactionType(Connection conn, String name) throws SQLException {
        String sql = "{call sp_insertTransactionType(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, name);
            stmt.execute();
        }
    }

    public void updateTransactionType(Connection conn, int id, String name) throws SQLException {
        String sql = "{call sp_updateTransactionType(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.execute();
        }
    }

    public void deleteTransactionType(Connection conn, int id) throws SQLException {
        String sql = "{call sp_deleteTransactionType(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}

