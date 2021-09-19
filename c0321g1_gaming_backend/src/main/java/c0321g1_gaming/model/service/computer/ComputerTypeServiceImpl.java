package c0321g1_gaming.model.service.computer;

import c0321g1_gaming.model.entity.computer.ComputerType;
import c0321g1_gaming.model.repository.computer.ComputerTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ComputerTypeServiceImpl implements ComputerTypeService{
    @Autowired
    ComputerTypeRepository computerTypeRepository;
    @Override
    public List<ComputerType> findAll() {
        return computerTypeRepository.findAll();
    }

    @Override
    public ComputerType findByName(String name) {
        return computerTypeRepository.findByName(name);
    }
}
