package c0321g1_gaming.model.service.computer;

import c0321g1_gaming.model.entity.computer.ComputerStatus;
import c0321g1_gaming.model.repository.computer.ComputerStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerStatusServiceImpl implements ComputerStatusService{
    @Autowired
    ComputerStatusRepository computerStatusRepository;
    @Override
    public List<ComputerStatus> findAll() {
        return computerStatusRepository.findAll();
    }

    @Override
    public ComputerStatus findByName(String name) {
        return computerStatusRepository.findByName(name);
    }
}
