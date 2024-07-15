package tesco.market.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tesco.market.entity.DiscountRequest;

public interface DiscountRepo extends JpaRepository<DiscountRequest, Integer> {
}
