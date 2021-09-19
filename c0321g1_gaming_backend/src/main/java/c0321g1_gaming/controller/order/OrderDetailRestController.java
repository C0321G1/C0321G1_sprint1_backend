package c0321g1_gaming.controller.order;


import c0321g1_gaming.dto.order.ListOrderDetailDto;
import c0321g1_gaming.model.entity.order.Order;
import c0321g1_gaming.model.entity.order.OrderDetail;
import c0321g1_gaming.model.entity.services.Services;
import c0321g1_gaming.model.service.order.IOrderService;
import c0321g1_gaming.model.service.order_detail.IOrderDetailService;
import c0321g1_gaming.model.service.services.IServicesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

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
    @Autowired
    IOrderService iOrderService;
    @Autowired
    IServicesService iServicesService;
    //vu code
    @PostMapping(value ="/create-detail/{id}")
    public ResponseEntity<Void> saveOrder(@Valid @ RequestBody ListOrderDetailDto listOrderDetailDto,
                                          BindingResult bindingResult ,@PathVariable Long id) {
        if (bindingResult.hasFieldErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
        }
        if (listOrderDetailDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else  {
            Order order = this.iOrderService.findById(id).orElse(null);
            for (int i = 0; i <listOrderDetailDto.getOrderDetailDtoList().size() ; i++) {
                Services services =this.iServicesService.findById(listOrderDetailDto.getOrderDetailDtoList().get(i).getServices().getServicesId());
                OrderDetail orderDetail =new OrderDetail();
                orderDetail.setOrder(order);
                orderDetail.setServices(services);
                orderDetail.setOrderDetailId(id);
                orderDetail.setQuantity(listOrderDetailDto.getOrderDetailDtoList().get(i).getQuantity());
                orderDetail.setTotalPrices(listOrderDetailDto.getOrderDetailDtoList().get(i).getTotalPrices());

                this.orderDetailService.createDetail(orderDetail);

            }

            return new ResponseEntity<>(HttpStatus.OK);
        }


    }
    @GetMapping("/{idOder}")
    public ResponseEntity<List<OrderDetail>> findAllOderDetailByOrderId(@PathVariable Long idOder){
        try{
            List<OrderDetail> orderDetailList = orderDetailService.findAllOderDetailsByOderId(idOder);
            if(orderDetailList.isEmpty()){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            return new ResponseEntity<>(orderDetailList,HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}