package c0321g1_gaming.model.service.employee.impl;

import c0321g1_gaming.model.entity.employee.Position;
import c0321g1_gaming.model.repository.employee.PositionRepository;
import c0321g1_gaming.model.service.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionRepository positionRepository;

    @Override
    public List<Position> getPositionList() {
        return positionRepository.getPositionList();
    }
}
