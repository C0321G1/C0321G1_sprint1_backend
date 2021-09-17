package c0321g1_gaming.controller_service.order;

import c0321g1_gaming.dto.order.OrderDto;
import c0321g1_gaming.model.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping(value = "order")

public class OrderRestController {
    @Autowired

    IOrderService orderService;


    @PostMapping(value = "/create")
    public ResponseEntity<Void> saveOrder(@RequestBody OrderDto orderDto) {
        if (orderDto.getOrderId() == null) {
            this.orderService.create(orderDto);
        } else if (orderDto.getCustomerId() == null) {
            return new ResponseEntity<>(HttpStatus.PAYMENT_REQUIRED);
        }
        return new ResponseEntity<>(HttpStatus.CREATED);//201
    }
}

