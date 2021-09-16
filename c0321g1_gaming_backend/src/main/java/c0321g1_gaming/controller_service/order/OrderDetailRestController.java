package c0321g1_gaming.controller_service.order;

import c0321g1_gaming.model.entity.order.OrderDetail;
import c0321g1_gaming.model.service.order_detail.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/oder_detail")
public class OrderDetailRestController {
    @Autowired
    IOrderDetailService orderDetailService;
    @GetMapping("/{id}")
    public ResponseEntity<List<OrderDetail>> findAllOderDetailByOrderId(@PathVariable Long id){
        List<OrderDetail> orderDetailList = orderDetailService.findAllOderDetailsByOderId(id);
        if(orderDetailList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(orderDetailList,HttpStatus.OK);
    }
}
