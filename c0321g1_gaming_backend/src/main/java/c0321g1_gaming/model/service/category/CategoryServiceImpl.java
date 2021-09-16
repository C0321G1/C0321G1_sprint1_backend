package c0321g1_gaming.model.service.category;

import c0321g1_gaming.model.entity.category.Category;
import c0321g1_gaming.model.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    //creator: Tra
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Optional<Category> finById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void createCategory() {
        categoryRepository.createCategory();
    }

    @Override
    public void saveCategory(Category category) {
        categoryRepository.save(category);
    }
}
