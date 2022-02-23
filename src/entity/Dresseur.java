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
public class Dresseur {
    private int id;
    private String nom;
    private String prenom;
    private String specialite;
    private String email;
    private String address;
    private String date;
    private int num;
    
    
   

    public Dresseur(int id, String nom, String prenom, String specialite, String email, String address, String date, int num) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.specialite = specialite;
        this.email = email;
        this.address = address;
        this.date = date;
        this.num = num;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSpecialite() {
        return specialite;
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

    public int getNum() {
        return num;
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

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
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

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Dresseur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", specialite=" + specialite + ", email=" + email + ", address=" + address + ", date=" + date + ", num=" + num + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
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
        final Dresseur other = (Dresseur) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    
    
}
