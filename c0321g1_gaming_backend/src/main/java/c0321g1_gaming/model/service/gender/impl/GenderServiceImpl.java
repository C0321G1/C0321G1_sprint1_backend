package c0321g1_gaming.model.service.gender.impl;

import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.repository.gender.GenderRepository;
import c0321g1_gaming.model.service.gender.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    GenderRepository genderRepository;
    @Override
    public List<Gender> findAll() {
        return genderRepository.findAll();
    }
}
