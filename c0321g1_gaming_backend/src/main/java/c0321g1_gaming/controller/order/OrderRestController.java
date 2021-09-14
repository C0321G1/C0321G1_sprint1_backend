package c0321g1_gaming.controller.order;

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
    private IOrderService orderService;

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
