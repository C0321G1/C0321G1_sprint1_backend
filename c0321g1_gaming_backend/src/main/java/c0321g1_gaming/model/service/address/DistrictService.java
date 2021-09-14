package c0321g1_gaming.model.service.address;
import c0321g1_gaming.model.entity.address.District;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface DistrictService {
    List<District> getDistrictList();

}
