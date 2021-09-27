package c0321g1_gaming.model.service.customer.impl;

import c0321g1_gaming.model.entity.customer.CustomerStatus;
import c0321g1_gaming.model.repository.customer.StatusRepository;
import c0321g1_gaming.model.service.customer.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {
    @Autowired
    StatusRepository statusRepository;

    @Override
    public List<CustomerStatus> getStatusList() {
        return statusRepository.getCustomerStatusList();
    }
}
