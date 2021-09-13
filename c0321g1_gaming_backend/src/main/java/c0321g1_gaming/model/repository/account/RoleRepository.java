package c0321g1_gaming.model.repository.account;

import c0321g1_gaming.model.entity.security.ERole;
import c0321g1_gaming.model.entity.security.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
