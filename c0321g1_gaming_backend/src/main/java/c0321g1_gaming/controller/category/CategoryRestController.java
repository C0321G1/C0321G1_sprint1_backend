package c0321g1_gaming.controller.category;

import c0321g1_gaming.model.entity.category.Category;
import c0321g1_gaming.model.service.category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("api/category")
public class CategoryRestController {

    //creator : Tra
    @Autowired
    CategoryService categoryService;

    @GetMapping("{id}")
    public ResponseEntity<Category> getCategory(@PathVariable Long id) {

        if (id == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Optional<Category> categoryOptional = categoryService.finById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryOptional.get(), HttpStatus.OK);
    }

    //creator : Tra
    @PatchMapping("edit")
    public ResponseEntity<Void> editCategory(@RequestBody Optional<Category> category) {

        if (!category.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        //thời gian logout
        String timeLogOut = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").format(new Date(System.currentTimeMillis()));

        //thời gian thực tế có thể sử dụng ,lúc login thành công
        String endTime = category.get().getEndTime();

        try {
            Date time1 = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").parse(timeLogOut);
            Date time2 = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").parse(endTime);

            //thời gian còn lại trong tài khoản
            double timeRemaining = (double) time2.getTime() - (double) time1.getTime();

            //thời gian còn lại trong tài khoản tính ra phút
            double timeRemainingSecond = TimeUnit.MILLISECONDS.toMinutes((long) timeRemaining);

            //số tiền còn lại trong tài khoản tương ứng với số thời gian còn lại
            double feeDouble = timeRemainingSecond / 60 * 20000;

            String fee = String.valueOf((int) feeDouble);
            category.get().setFee(fee);

            //set startTime = null sau khi logout
            category.get().setStartTime(null);


            //set endTime = null sau khi logout
            category.get().setEndTime(null);
            categoryService.saveCategory(category.get());

        } catch (ParseException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
