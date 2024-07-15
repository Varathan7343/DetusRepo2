package tesco.market.service;
// DiscountService.java
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Service;
import tesco.market.entity.Bill;
import tesco.market.entity.User;
import tesco.market.enums.UserType;

@Service
public class DiscountService {

    public double calculateNetPayableAmount(User user, Bill bill) {
        double discount = 0;

        if (!bill.isGrocery()) {
            if (user.getUserType() == UserType.EMPLOYEE) {
                discount = 0.30;
            } else if (user.getUserType() == UserType.AFFILIATE) {
                discount = 0.10;
            } else if (user.getUserType() == UserType.CUSTOMER && isCustomerForOverTwoYears(user)) {
                discount = 0.05;
            }
        }

        double percentageDiscount = bill.getAmount() * discount;
        double additionalDiscount = (int)(bill.getAmount() / 100) * 5;
        return bill.getAmount() - percentageDiscount - additionalDiscount;
    }

    private boolean isCustomerForOverTwoYears(User user) {
        return ChronoUnit.YEARS.between(user.getRegistrationDate(), LocalDate.now()) > 2;
    }
}
