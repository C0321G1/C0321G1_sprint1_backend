package c0321g1_gaming.dto.order;

import java.util.List;

public class ListOrderDetailDto {
    private List<OrderDetailDto> orderDetailDtoList;

    public ListOrderDetailDto(List<OrderDetailDto> orderDetailDtoList) {
        this.orderDetailDtoList = orderDetailDtoList;
    }

    public List<OrderDetailDto> getOrderDetailDtoList() {
        return orderDetailDtoList;
    }

    public void setOrderDetailDtoList(List<OrderDetailDto> orderDetailDtoList) {
        this.orderDetailDtoList = orderDetailDtoList;
    }

    public ListOrderDetailDto() {
    }

}