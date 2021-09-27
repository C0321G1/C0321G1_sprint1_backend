package c0321g1_gaming.model.service.category;

import c0321g1_gaming.model.entity.category.Category;
import c0321g1_gaming.model.repository.category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
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

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void addMoneyAccount(Category category, int moneyHour) {
        int feeValue = Integer.parseInt(category.getFee()) + moneyHour;
        String fee = String.valueOf(feeValue);
        category.setFee(fee);
        try {
            Date date = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").parse(category.getEndTime());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            double timeDouble = moneyHour / 20000 * 60 * 60;
            int timeInt = (int) timeDouble;
            calendar.add(Calendar.SECOND, timeInt);
            Date end = calendar.getTime();
            String endTime = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(end);
            category.setEndTime(endTime);
            saveCategory(category);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
