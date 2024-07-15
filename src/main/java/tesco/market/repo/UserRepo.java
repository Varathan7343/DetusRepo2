package tesco.market.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import tesco.market.entity.User;

public interface UserRepo extends JpaRepository<User,Integer> {
}
