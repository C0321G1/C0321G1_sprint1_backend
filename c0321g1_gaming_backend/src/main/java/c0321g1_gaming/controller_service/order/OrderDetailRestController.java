package c0321g1_gaming.controller_service.order;


import c0321g1_gaming.dto.order.OrderDetailDto;

import c0321g1_gaming.model.entity.order.OrderDetail;
import c0321g1_gaming.model.service.order_detail.IOrderDetailService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin("http://localhost:4200/")
@RestController
@RequestMapping(value = "order-detail")
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
     //  vu code
    @PostMapping(value = "/create-detail", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> saveOrder(@Valid  @RequestBody OrderDetailDto orderDetailDto , BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        if (orderDetailDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else  {
            OrderDetail orderDetail =new OrderDetail();
            BeanUtils.copyProperties(orderDetailDto,orderDetail);
            this.orderDetailService.createDetail(orderDetail);
            return new ResponseEntity<>(HttpStatus.OK);
        }


    }
}
