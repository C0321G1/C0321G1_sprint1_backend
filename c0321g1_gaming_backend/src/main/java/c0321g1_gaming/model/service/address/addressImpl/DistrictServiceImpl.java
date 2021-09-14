package c0321g1_gaming.model.service.address.addressImpl;

import c0321g1_gaming.model.entity.address.District;
import c0321g1_gaming.model.repository.address.DistrictRepository;
import c0321g1_gaming.model.service.address.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public Iterable<District> findAll() {
        return districtRepository.findAll();
    }
}
