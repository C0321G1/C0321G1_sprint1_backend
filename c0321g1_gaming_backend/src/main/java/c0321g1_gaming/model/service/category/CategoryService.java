package c0321g1_gaming.model.service.category;

import c0321g1_gaming.model.entity.category.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    //creator: Tra
    Optional<Category> finById(Long id);

    void createCategory();

    void saveCategory(Category category);

    List<Category> findAll();
    void addMoneyAccount(Category category, int moneyHour);
}
