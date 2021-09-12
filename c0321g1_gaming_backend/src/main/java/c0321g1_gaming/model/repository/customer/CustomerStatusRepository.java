package c0321g1_gaming.model.repository.customer;

import c0321g1_gaming.model.entity.customer.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerStatusRepository extends JpaRepository<CustomerStatus, Long> {
}
