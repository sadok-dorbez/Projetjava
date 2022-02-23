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
public class RateDre {
    private int id;

    private int rateValue;
    private User userId;
    private Dresseur DreId;

    
    public RateDre(int id, int rateValue, User userId, Dresseur DreId) {
        this.id = id;
        this.rateValue = rateValue;
        this.userId = userId;
        this.DreId = DreId;
    }

    public int getId() {
        return id;
    }

    public int getRateValue() {
        return rateValue;
    }

    public User getUserId() {
        return userId;
    }

    public Dresseur getDreId() {
        return DreId;
    }
   
   

    public void setRateValue(int rateValue) {
        this.rateValue = rateValue;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public void setDreId(Dresseur DreId) {
        this.DreId = DreId;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + this.id;
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
        final RateDre other = (RateDre) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "RateDre{" + "id=" + id + ", rateValue=" + rateValue + ", userId=" + userId + ", DreId=" + DreId + '}';
    }
    
    
    
    
    
}
