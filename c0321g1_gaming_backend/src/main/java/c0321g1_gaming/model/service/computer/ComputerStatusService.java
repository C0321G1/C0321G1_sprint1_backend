package c0321g1_gaming.model.service.computer;

import c0321g1_gaming.model.entity.computer.ComputerStatus;
import c0321g1_gaming.model.entity.computer.ComputerType;

import java.util.List;

public interface ComputerStatusService {
    List<ComputerStatus> findAll();
    ComputerStatus findByName(String name);
}
