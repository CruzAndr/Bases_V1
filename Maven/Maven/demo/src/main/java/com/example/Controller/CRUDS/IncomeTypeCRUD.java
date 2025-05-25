package com.example.Controller.CRUDS;

import java.sql.*;

public class IncomeTypeCRUD {

    public void readIncomeTypes(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readIncomeTypes()";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("C_Income_Type") +
                                   ", Description: " + rs.getString("D_Description"));
            }
        }
    }

    public void insertIncomeType(Connection conn, String description) throws SQLException {
        String sql = "{call sp_insertIncomeType(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, description);
            stmt.execute();
        }
    }

    public void updateIncomeType(Connection conn, int id, String description) throws SQLException {
        String sql = "{call sp_updateIncomeType(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, description);
            stmt.execute();
        }
    }

    public void deleteIncomeType(Connection conn, int id) throws SQLException {
        String sql = "{call sp_deleteIncomeType(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
