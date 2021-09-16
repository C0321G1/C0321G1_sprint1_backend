package c0321g1_gaming.model.repository.category;

import c0321g1_gaming.model.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Repository

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //creator: Tra
    @Query(value = "select * from category where category_id = ?1", nativeQuery= true)
    Optional<Category> findById(Long id);

    @Transactional
    @Modifying
    @Query(value = "INSERT into category (discount, description, type)" +
            "values ('10%','1h 20.000 VND * số giờ chơi', 'Theo giờ')", nativeQuery = true)
    void createCategory();
}
