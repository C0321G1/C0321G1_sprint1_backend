package c0321g1_gaming.model.service.computer;

import c0321g1_gaming.model.entity.computer.Computer;
import c0321g1_gaming.model.entity.computer.ComputerManufacturer;

import java.util.List;

public interface ComputerManufacturerService {
    List<ComputerManufacturer> findAll();
}