package c0321g1_gaming.model.service.services;

import c0321g1_gaming.model.entity.services.Services;

public interface IServicesService {
    void save(Services services);

    Services findById(Long id);
}
