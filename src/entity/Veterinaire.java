/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author sadok
 */
public class Veterinaire {
    private int id;
    private String nom;
    private String prenom;
    private String email;
    private String address;
    private String date;
    
    

    public Veterinaire(int id, String nom, String prenom, String email, String address, String date) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.address = address;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    @Override
    public String toString() {
        return "Veterinaire{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", address=" + address + ", date=" + date + '}';
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veterinaire other = (Veterinaire) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
 
   
    
    
    
    
}
