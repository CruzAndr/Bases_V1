package com.example.Controller.CRUDS;

import java.sql.*;

public class ProjectionTypeCRUD {

    public void readProjectionTypes(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readProjectionTypes()";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("C_Projection_Type") +
                                   ", Description: " + rs.getString("D_Projection_Type_Description"));
            }
        }
    }

    public void insertProjectionType(Connection conn, String description) throws SQLException {
        String sql = "{call sp_insertProjectionType(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, description);
            stmt.execute();
        }
    }

    public void updateProjectionType(Connection conn, int id, String description) throws SQLException {
        String sql = "{call sp_updateProjectionType(?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, description);
            stmt.execute();
        }
    }

    public void deleteProjectionType(Connection conn, int id) throws SQLException {
        String sql = "{call sp_deleteProjectionType(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
