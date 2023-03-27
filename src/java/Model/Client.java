/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author asus
 */
package Model;

public class Client {
    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public int getTotal() {
        return Total;
    }

    public void setTotal(int total) {
        Total = total;
    }

    public Client(int id, String nom, int total) {
        Id = id;
        Nom = nom;
        Total = total;
    }
    public Client() {
        Id = 0;
        Nom = "";
        Total = 0;
    }

    private int Id;
    private String Nom;
    private int Total;

}
