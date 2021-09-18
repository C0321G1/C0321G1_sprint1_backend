package c0321g1_gaming.model.service.computer;

import c0321g1_gaming.model.entity.computer.ComputerType;
import java.util.List;

public interface ComputerTypeService {
    List<ComputerType> findAll();
    ComputerType findByName(String name);
}
