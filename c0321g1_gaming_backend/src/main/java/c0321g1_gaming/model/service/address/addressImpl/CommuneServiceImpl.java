package c0321g1_gaming.model.service.address.addressImpl;

import c0321g1_gaming.model.entity.address.Commune;
import c0321g1_gaming.model.repository.address.CommuneRepository;
import c0321g1_gaming.model.service.address.CommuneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CommuneServiceImpl implements CommuneService {

    @Autowired
    CommuneRepository communeRepository;


    @Override
    public List<Commune> getCommuneList() {
        return communeRepository.getCommuneList();
    }
}
