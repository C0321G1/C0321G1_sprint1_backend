package c0321g1_gaming.model.service.address.impl;

import c0321g1_gaming.model.entity.address.District;
import c0321g1_gaming.model.repository.address.DistrictRepository;
import c0321g1_gaming.model.service.address.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictServiceImpl implements DistrictService {

    @Autowired
    DistrictRepository districtRepository;

    @Override
    public List<District> getDistrictList() {
        return districtRepository.getDistrictList();
    }
}