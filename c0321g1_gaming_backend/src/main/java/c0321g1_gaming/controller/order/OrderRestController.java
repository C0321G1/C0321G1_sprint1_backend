package c0321g1_gaming.controller.order;

import c0321g1_gaming.model.entity.order.Orders;
import c0321g1_gaming.model.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderRestController {
    @Autowired

    IOrderService orderService;
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Orders>> findAllOder(@PageableDefault(value = 5) Pageable pageable){
        Page<Orders> page = orderService.findAllOder(pageable);
        if(page.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(page,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Page<Orders>> findAllOderByCustomerId(@PageableDefault(value = 5) Pageable pageable,
                                                                @PathVariable Long id){
        Page<Orders> page = orderService.findOderByIdCustomer(pageable,id);
        if(page.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(page,HttpStatus.OK);
    }

    @PatchMapping(value ="/{id}")
    public ResponseEntity<Page<Orders>> confirmPayment(@PageableDefault(value = 5) Pageable pageable,
                                                                @PathVariable Long id){
        Optional<Orders> optionalOrders = orderService.findById(id);
        if(!optionalOrders.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderService.confirmPayments(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
