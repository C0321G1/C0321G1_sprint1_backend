package c0321g1_gaming.controller.category;

import c0321g1_gaming.model.entity.category.Category;
import c0321g1_gaming.model.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/category")
public class CategoryRestController {

    //creator : Tra
    @Autowired
    CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {
        Optional<Category> categoryOptional = categoryService.finById(id);

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (id.equals("")) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }

}
