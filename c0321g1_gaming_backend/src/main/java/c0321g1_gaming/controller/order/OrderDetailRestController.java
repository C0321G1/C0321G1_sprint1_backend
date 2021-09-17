package c0321g1_gaming.controller.order;

import c0321g1_gaming.model.entity.order.OrderDetail;
import c0321g1_gaming.model.service.order_detail.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping(value = "/order_detail")
public class OrderDetailRestController {
    @Autowired
    IOrderDetailService orderDetailService;
    @GetMapping("/{idOder}")
    public ResponseEntity<List<OrderDetail>> findAllOderDetailByOrderId(@PathVariable Long idOder){
        List<OrderDetail> orderDetailList = orderDetailService.findAllOderDetailsByOderId(idOder);
        if(orderDetailList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(orderDetailList,HttpStatus.OK);
    }
}