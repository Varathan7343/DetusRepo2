package tesco.market.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tesco.market.entity.DiscountRequest;
import tesco.market.service.DiscountService;

@RestController
@RequestMapping("/api/discount")
public class DiscountController {

    @Autowired
    private DiscountService discountService;

    @PostMapping("/calculate")
    public double calculateNetPayableAmount(@RequestBody DiscountRequest request) {
        return discountService.calculateNetPayableAmount(request.getUser(), request.getBill());
    }
}
