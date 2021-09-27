package c0321g1_gaming.model.service.services.impl;

import c0321g1_gaming.model.entity.services.Unit;
import c0321g1_gaming.model.repository.services.IUnitRepository;
import c0321g1_gaming.model.service.services.IUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UnitServiceImpl implements IUnitService {
    @Autowired
    IUnitRepository unitRepository;

    @Override
    public List<Unit> findAll() {
        return unitRepository.findAllUnit();
    }
}