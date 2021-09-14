package c0321g1_gaming.controller.order;


import c0321g1_gaming.dto.order.OrderDetailDto;
import c0321g1_gaming.model.service.order_detail.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping(value = "orders_detail")
public class OrderDetailRestController {
    @Autowired
    private IOrderDetailService orderDetailService;

    @PostMapping(value = "/create")
    private ResponseEntity<Void> saveOrder(@RequestBody OrderDetailDto orderDetailDto) {
        if (orderDetailDto.getOrderId() == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }else if (orderDetailDto.getServiceId() ==null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        this.orderDetailService.createDetail(orderDetailDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
