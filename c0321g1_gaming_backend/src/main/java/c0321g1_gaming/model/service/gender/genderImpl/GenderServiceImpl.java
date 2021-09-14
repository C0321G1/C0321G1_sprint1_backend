package c0321g1_gaming.model.service.gender.genderImpl;

import c0321g1_gaming.model.entity.gender.Gender;
import c0321g1_gaming.model.repository.gender.GenderRepository;
import c0321g1_gaming.model.service.gender.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl implements GenderService {
    @Autowired
    private GenderRepository genderRepository;

    @Override
    public Iterable<Gender> findAll() {
        return genderRepository.findAll();
    }
}
