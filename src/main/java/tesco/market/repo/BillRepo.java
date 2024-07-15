package tesco.market.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tesco.market.entity.Bill;

public interface BillRepo extends JpaRepository<Bill, Integer> {
}
