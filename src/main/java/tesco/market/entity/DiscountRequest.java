package tesco.market.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class DiscountRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int discountRequestId;
    private User user;
    private Bill bill;

    public User getUser() {
        return user;
    }

    public Bill getBill() {
        return bill;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }
}
