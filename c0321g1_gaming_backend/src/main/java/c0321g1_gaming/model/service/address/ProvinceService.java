package c0321g1_gaming.model.service.address;

import c0321g1_gaming.model.entity.address.Province;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProvinceService {
    List<Province> getProvinceList();

}
