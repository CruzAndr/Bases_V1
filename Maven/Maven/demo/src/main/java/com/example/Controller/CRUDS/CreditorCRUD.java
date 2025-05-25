package com.example.Controller.CRUDS;

import java.sql.*;

public class CreditorCRUD {

    public void readCreditors(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readCreditors()";
        try (Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("C_Creditor") +
                                   ", Name: " + rs.getString("D_Name"));
            }
        }
    }

    public void insertCreditor(Connection conn, String name, String email, String password,
                               int phone, String province, String county, String district,
                               String address) throws SQLException {
        String sql = "{call sp_insertCreditor(?, ?, ?, ?, ?, ?, ?, ?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.setInt(4, phone);
            stmt.setString(5, province);
            stmt.setString(6, county);
            stmt.setString(7, district);
            stmt.setString(8, address);
            stmt.execute();
        }
    }

    public void updateCreditor(Connection conn, int id, String name, String email, String password,
                               int phone, String province, String county, String district,
                               String address) throws SQLException {
        String sql = "{call sp_updateCreditor(?, ?, ?, ?, ?, ?, ?, ?, ?)}";
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
            stmt.execute();
        }
    }

    public void deleteCreditor(Connection conn, int id) throws SQLException {
        String sql = "{call sp_deleteCreditor(?)}";
        try (CallableStatement stmt = conn.prepareCall(sql)) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}