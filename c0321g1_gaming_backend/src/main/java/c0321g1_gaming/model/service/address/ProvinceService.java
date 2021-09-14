package c0321g1_gaming.model.service.address;

import c0321g1_gaming.model.entity.address.Commune;
import c0321g1_gaming.model.entity.address.Province;

public interface ProvinceService {
    Iterable<Province> findAll();
}
