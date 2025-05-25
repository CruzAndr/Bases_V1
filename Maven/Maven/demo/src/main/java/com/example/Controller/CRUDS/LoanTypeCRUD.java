package com.example.Controller.CRUDS;

import java.sql.*;

// ===================== LoanTypeCRUD =====================
public class LoanTypeCRUD {
    public void readLoanTypes(Connection conn) throws SQLException {
        String sql = "SELECT * FROM fn_readLoanTypes()";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("C_Loan_Type") + ", Name: " + rs.getString("D_Loan_Type_Name"));
            }
        }
    }

    public void insertLoanType(Connection conn, String name) throws SQLException {
        try (CallableStatement stmt = conn.prepareCall("{call sp_insertLoanType(?)}")) {
            stmt.setString(1, name);
            stmt.execute();
        }
    }

    public void updateLoanType(Connection conn, int id, String name) throws SQLException {
        try (CallableStatement stmt = conn.prepareCall("{call sp_updateLoanType(?, ?)}")) {
            stmt.setInt(1, id);
            stmt.setString(2, name);
            stmt.execute();
        }
    }

    public void deleteLoanType(Connection conn, int id) throws SQLException {
        try (CallableStatement stmt = conn.prepareCall("{call sp_deleteLoanType(?)}")) {
            stmt.setInt(1, id);
            stmt.execute();
        }
    }
}

