package com.example.Controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private String user = "DekSUS";      // tu login SQL exacto
    private String pass = "2404";                // tu contraseña SQL exacta
    private String db   = "Grupo3_IF51002025_V2";
    private String ip   = "192.168.100.66"; // La IP correcta que se obtiene con el CMD al ejecutar ipconfig y se busca la que tenga IPv4
    private String port = "1433";

    public Connection obtenerConexion() {
        // Ponemos el usuario y la contraseña en la URL
        String url = String.format(
            "jdbc:sqlserver://%s:%s;databaseName=%s;user=%s;password=%s;encrypt=true;trustServerCertificate=true",
            ip, port, db, user, pass
        );

        try {
            // Opcional, fuerza la carga del driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection conn = DriverManager.getConnection(url);
            JOptionPane.showMessageDialog(null, "Conexión exitosa a la Base de Datos");
            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Driver no encontrado:\n" + e.getMessage());
        } catch (SQLException e) {
            // Mostramos el SQLState y el error para diagnosticar mejor
            e.printStackTrace();
            JOptionPane.showMessageDialog(null,
                "Error de conexión:\n" +
                "SQLState: " + e.getSQLState() + "\n" +
                "ErrorCode: " + e.getErrorCode() + "\n" +
                e.getMessage()
            );
        }
        return null;
    }
}