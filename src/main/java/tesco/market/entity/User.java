package tesco.market.entity;


import jakarta.persistence.*;
import tesco.market.enums.UserType;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    private String userName;
    @Enumerated(EnumType.STRING)
    private UserType userType;
    private LocalDate registrationDate;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public UserType getUserType() {
        return userType;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }
}
