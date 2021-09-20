package c0321g1_gaming.controller.order;

import c0321g1_gaming.dto.order.OrderDto;
import c0321g1_gaming.model.entity.order.Order;
import c0321g1_gaming.model.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    //vu code
    @PostMapping(value = "/create")
    public ResponseEntity<?> saveOrder(@RequestBody OrderDto orderDto) {
        if (orderDto.getOrderId() == null) {
            this.orderService.create(orderDto);
        } else if (orderDto.getCustomerId() == null) {
            return new ResponseEntity<>(HttpStatus.PAYMENT_REQUIRED);
        }
        Long id = this.orderService.maxIdOrder();
        Order order =this.orderService.findById(id).orElse(null);
        return new ResponseEntity<>(order,HttpStatus.CREATED);//201
    }
    // Huynh code
    @GetMapping(value = "/list")
    public ResponseEntity<Page<Order>> findAllOder(@PageableDefault(value = 5, sort = "status", direction = Sort.Direction.DESC) Pageable pageable) {
        try {
            Page<Order> page = orderService.findAllOder(pageable);
            if (page.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(page, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // Huynh code
    @GetMapping(value = "/{idCustomer}")
    public ResponseEntity<Page<Order>> findAllOderByCustomerId(@PageableDefault(value = 5, sort = "status", direction = Sort.Direction.DESC) Pageable pageable,
                                                               @PathVariable Long idCustomer) {
        try {
            Page<Order> page = orderService.findOderByIdCustomer(pageable, idCustomer);
            if (page.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(page, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // Huynh code
    @GetMapping(value = "/getOrder/{idOder}")
    public ResponseEntity<Order> findOrderByIdOrder(@PathVariable Long idOder) {
        try {
            Optional<Order> optionalOrder = orderService.findById(idOder);
            if (!optionalOrder.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(optionalOrder.get(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    // Huynh code
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Void> confirmPayment(@PathVariable Long id) {
        try {
            Optional<Order> optionalOrders = orderService.findById(id);
            if (!optionalOrders.isPresent()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Order order = optionalOrders.get();
            order.setStatus(0);
            orderService.saveOrder(order);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}