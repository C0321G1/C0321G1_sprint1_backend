package c0321g1_gaming.model.service.computer;

import c0321g1_gaming.model.entity.computer.ComputerManufacturer;
import c0321g1_gaming.model.repository.computer.ComputerManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerManufacturerServiceImpl implements ComputerManufacturerService{
    @Autowired
    ComputerManufacturerRepository computerManufacturerRepository;
    @Override
    public List<ComputerManufacturer> findAll() {
        return computerManufacturerRepository.findAll();
    }

    @Override
    public ComputerManufacturer findByName(String name) {
        return computerManufacturerRepository.findByName(name);
    }
}
