package c0321g1_gaming.model.service.services;

import c0321g1_gaming.model.entity.services.Services;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.xml.ws.Service;
import java.util.List;

public interface IServicesService {
    void save(Services services);
    Page<Services> pageServicesAll(String name, Pageable pageable);
    Services findById(Long id);
    Page<Services> pageServicesCodeNamePrices(String code,String name,String prices,Pageable pageable);
    void update(Services services);
    List<Services> listServices();
    Services findByIdServices(Long id);


}