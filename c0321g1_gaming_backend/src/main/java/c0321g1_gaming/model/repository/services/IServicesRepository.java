package c0321g1_gaming.model.repository.services;

import c0321g1_gaming.model.entity.services.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IServicesRepository extends JpaRepository<Services,Long> {

}
