package Controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asus
 */


import Model.Client;
import java.sql.*;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;



public class DaoClientDB {
    String url = "jdbc:mysql://localhost:3306/jee";
    String username = "root";
    String password = "1234";
    

    private  static Connection getConnection(String url, String username, String password) throws SQLException{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DaoClientDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        return DriverManager.getConnection(url, username, password);
    }

    public ArrayList<Client> getClients() throws SQLException {
        ArrayList<Client> Clients = new ArrayList<Client>();
        try {
            Connection conn = getConnection("jdbc:mysql://localhost:3306/jee?autoReconnect=true&useSSL=false", "root", "1234");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM client");
            while (rs.next()) {
                Clients.add(new Client(rs.getInt("id"), rs.getString("nom"), rs.getInt("total")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Clients;
    }


    public void addClient(String nom,int total) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection("jdbc:mysql://localhost:3306/jee?autoReconnect=true&useSSL=false", "root", "1234");
            PreparedStatement ps = conn.prepareStatement("INSERT INTO `jee`.`client` (`nom`, `total`) VALUES (?, ?)");
            ps.setString(1, nom);
            ps.setInt(2, total);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        } finally {
            // close database connection
            if (conn != null) {
                conn.close();
            }
        }

    }

    public void deleteClient(int id) throws SQLException {
        Connection conn = null;
        try {
            conn = getConnection("jdbc:mysql://localhost:3306/jee?autoReconnect=true&useSSL=false", "root", "1234");
            PreparedStatement ps = conn.prepareStatement("DELETE FROM client WHERE id = ?");
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println(rows + " row(s) inserted.");
        } finally {
            // close database connection
            if (conn != null) {
                conn.close();
            }
        }

    }
}

