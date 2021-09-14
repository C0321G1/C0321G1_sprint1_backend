package c0321g1_gaming.controller.order;

import c0321g1_gaming.dto.order.OrderDto;
import c0321g1_gaming.model.entity.order.Order;
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
@CrossOrigin("http://localhost:4200/")
@RequestMapping(value = "order")

public class OrderRestController {
    @Autowired

    IOrderService orderService;
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Order>> findAllOder(@PageableDefault(value = 5) Pageable pageable){
        Page<Order> page = orderService.findAllOder(pageable);
        if(page.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(page,HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Page<Order>> findAllOderByCustomerId(@PageableDefault(value = 5) Pageable pageable,
                                                                @PathVariable Long id){
        Page<Order> page = orderService.findOderByIdCustomer(pageable,id);
        if(page.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(page,HttpStatus.OK);
    }

    @PatchMapping(value ="/{id}")
    public ResponseEntity<Page<Order>> confirmPayment(@PageableDefault(value = 5) Pageable pageable,
                                                      @PathVariable Long id){
        Optional<Order> optionalOrders = orderService.findById(id);
        if(!optionalOrders.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderService.confirmPayments(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDto orderDto){
        if (orderDto.getOrderId()==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else if (orderDto.getCustomerId() == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        this.orderService.create(orderDto);
        return new ResponseEntity<>(HttpStatus.CREATED);//201
    }

}
