package com.example.Controller.CRUDS;

import java.sql.*;

public class UserCRUD {

    public void readUsers(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readUsers()";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("C_User") +
                                   ", Name: " + rs.getString("D_Name") +
                                   ", Email: " + rs.getString("D_Email"));
            }
        }
    }

    public void insertUser(Connection conn, String name, String email, String password,
                           int phone, String province, String county, String district,
                           String address, String role, String status, Timestamp registrationDate) throws SQLException {
        String sql = "{call sp_insertUser(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setInt(4, phone);
            stmt.setString(5, province);
            stmt.setString(6, county);
            stmt.setString(7, district);
            stmt.setString(8, address);
            stmt.setString(9, role);
            stmt.setString(10, status);
            stmt.setTimestamp(11, registrationDate);
            stmt.execute();
        }
    }

    public void updateUser(Connection conn, int id, String name, String email, String password,
                           int phone, String province, String county, String district,
                           String address, String role, String status) throws SQLException {
        String sql = "{call sp_updateUser(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.setString(3, email);
            stmt.setString(4, password);
            stmt.setInt(5, phone);
            stmt.setString(6, province);
            stmt.setString(7, county);
            stmt.setString(8, district);
            stmt.setString(9, address);
            stmt.setString(10, role);
            stmt.setString(11, status);
            stmt.execute();
        }
    }

    public void deleteUser(Connection conn, int id) throws SQLException {
        String sql = "{call sp_deleteUser(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}
