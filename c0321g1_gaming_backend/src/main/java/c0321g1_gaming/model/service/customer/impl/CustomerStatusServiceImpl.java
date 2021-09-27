package c0321g1_gaming.model.service.customer.impl;

import c0321g1_gaming.model.entity.customer.CustomerStatus;
import c0321g1_gaming.model.repository.customer.CustomerStatusRepository;
import c0321g1_gaming.model.service.customer.CustomerStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerStatusServiceImpl implements CustomerStatusService {
    @Autowired
    CustomerStatusRepository customerStatusRepository;
    @Override
    public List<CustomerStatus> getAllCustomerStatus() {
        return customerStatusRepository.getAllCustomerStatus();
    }
}
