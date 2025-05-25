package com.example.Controller.CRUDS;

import java.sql.*;

public class DebtTypeCRUD {

    public void readDebtTypes(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readDebtTypes()";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("C_Debt_Type") +
                                   ", Name: " + rs.getString("D_Debt_Type_Name"));
            }
        }
    }

    public void insertDebtType(Connection conn, String name) throws SQLException {
        String sql = "{call sp_insertDebtType(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, name);
            stmt.execute();
        }
    }

    public void updateDebtType(Connection conn, int id, String name) throws SQLException {
        String sql = "{call sp_updateDebtType(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.execute();
        }
    }

    public void deleteDebtType(Connection conn, int id) throws SQLException {
        String sql = "{call sp_deleteDebtType(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}