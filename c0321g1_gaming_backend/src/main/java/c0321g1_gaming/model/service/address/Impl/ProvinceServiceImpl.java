package c0321g1_gaming.model.service.address.impl;

import c0321g1_gaming.model.entity.address.Province;
import c0321g1_gaming.model.repository.address.ProvinceRepository;
import c0321g1_gaming.model.service.address.ProvinceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements ProvinceService {
    @Autowired
    ProvinceRepository provinceRepository;

    @Override
    public List<Province> findAll() {
        return provinceRepository.findAll();
    }
}
