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
public class RateVet {
    private int id;
    private int rateValue;
    private User userId;
    private Veterinaire VetId;

    public RateVet(int id, int rateValue, User userId, Veterinaire VetId) {
        this.id = id;
        this.rateValue = rateValue;
        this.userId = userId;
        this.VetId = VetId;
    }

    public int getId() {
        return id;
    }

    public User getUserId() {
        return userId;
    }

    public Veterinaire getVetId() {
        return VetId;
    }

 

    public int getRateValue() {
        return rateValue;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 41 * hash + this.id;
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
        final RateVet other = (RateVet) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    public void setRateValue(int rateValue) {
        this.rateValue = rateValue;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void setVetId(Veterinaire VetId) {
        this.VetId = VetId;
    }

    @Override
    public String toString() {
        return "RateVet{" + "id=" + id + ", rateValue=" + rateValue + ", userId=" + userId + ", VetId=" + VetId + '}';
    }
    
    
    
    
}
