package c0321g1_gaming.model.service.services.impl;

import c0321g1_gaming.model.entity.services.Services;
import c0321g1_gaming.model.repository.services.IServicesRepository;
import c0321g1_gaming.model.repository.services.IUnitRepository;
import c0321g1_gaming.model.service.services.IServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesServiceImpl implements IServicesService {
    @Autowired
    IServicesRepository servicesRepository;

    @Autowired
    IUnitRepository unitRepository;

    @Override
    public void save(Services services) {
        List<Services> servicesList = servicesRepository.findAll();
        String code = "";
        if (servicesList.isEmpty()){
            code = "SV-0001";
        }else {
            Long lastId = servicesList.get(servicesList.size() - 1).getServicesId();
            if (lastId < 10){
                code = "SV-000" + (lastId+1);
            }else if (lastId< 100){
                code = "SV-00" + (lastId+1);
            }else if (lastId < 1000){
                code = "SV-0" + (lastId +1);
            }else {
                code= "SV" + lastId;
            }
        }
        services.setCode(code);
        servicesRepository.save(services);
    }

    @Override
    public Services findById(Long id) {
        return servicesRepository.findById(id).orElse(null);
    }
}
