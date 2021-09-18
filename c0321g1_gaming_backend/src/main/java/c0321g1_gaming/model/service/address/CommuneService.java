package c0321g1_gaming.model.service.address;

import c0321g1_gaming.model.entity.address.Commune;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommuneService {
    List<Commune> getCommuneList();
}
