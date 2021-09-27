package c0321g1_gaming.model.repository.customer;

import c0321g1_gaming.model.entity.customer.CustomerStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StatusRepository extends JpaRepository<CustomerStatus,Long> {
    @Query(value="select * from customer_status", nativeQuery = true)
    List<CustomerStatus> getCustomerStatusList();
}
