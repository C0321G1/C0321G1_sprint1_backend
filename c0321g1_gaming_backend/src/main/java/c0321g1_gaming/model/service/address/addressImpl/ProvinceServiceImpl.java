package c0321g1_gaming.model.service.address.addressImpl;

import c0321g1_gaming.model.entity.address.Province;
import c0321g1_gaming.model.repository.address.ProvinceRepository;
import c0321g1_gaming.model.service.address.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    private ProvinceRepository provinceRepository;

    @Override
    public Iterable<Province> findAll() {
        return provinceRepository.findAll();
    }
}
