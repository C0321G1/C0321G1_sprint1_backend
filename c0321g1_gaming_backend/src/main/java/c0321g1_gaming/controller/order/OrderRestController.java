package c0321g1_gaming.controller.order;

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
@RequestMapping("/order")
public class OrderRestController {
    @Autowired

    IOrderService orderService;

    @GetMapping(value = "/list")
    public ResponseEntity<Page<Order>> findAllOder(@PageableDefault(value = 5) Pageable pageable) {
        Page<Order> page = orderService.findAllOder(pageable);
        if (page.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @GetMapping(value = "/{idCustomer}")
    public ResponseEntity<Page<Order>> findAllOderByCustomerId(@PageableDefault(value = 5) Pageable pageable,
                                                               @PathVariable Long idCustomer) {
        Page<Order> page = orderService.findOderByIdCustomer(pageable, idCustomer);
        if (page.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(page, HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Void> confirmPayment(@PathVariable Long id) {
        Optional<Order> optionalOrders = orderService.findById(id);
        if (!optionalOrders.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        orderService.confirmPayments(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
