package com.example.Controller.CRUDS;

import java.sql.*;

public class SavingTypeCRUD {

    public void readSavingTypes(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readSavingTypes()";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("C_Saving_Type") +
                                   ", Name: " + rs.getString("D_Saving_Type_Name"));
            }
        }
    }

    public void insertSavingType(Connection conn, String name) throws SQLException {
        String sql = "{call sp_insertSavingType(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, name);
            stmt.execute();
        }
    }

    public void updateSavingType(Connection conn, int id, String name) throws SQLException {
        String sql = "{call sp_updateSavingType(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.execute();
        }
    }

    public void deleteSavingType(Connection conn, int id) throws SQLException {
        String sql = "{call sp_deleteSavingType(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
    
}
