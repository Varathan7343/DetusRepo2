package tesco.market.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class Bill implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int billId;
    private double amount;
    private boolean isGrocery;

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public double getAmount() {
        return amount;
    }

    public boolean isGrocery() {
        return isGrocery;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setGrocery(boolean grocery) {
        isGrocery = grocery;
    }
}
