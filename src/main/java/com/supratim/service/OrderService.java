package com.supratim.service;

import com.supratim.domain.OrderStatus;
import com.supratim.domain.PaymentType;
import com.supratim.payload.dto.OrderDTO;

import java.util.List;

public interface OrderService {

    OrderDTO createOrder(OrderDTO orderDTO) throws Exception;
    OrderDTO getOrderById(Long Id) throws Exception;
    List<OrderDTO> getOrdersByBranch(Long branchId,
                                     Long customerId,
                                     Long cashierId,
                                     PaymentType paymentType,
                                     OrderStatus status) throws Exception;

    List<OrderDTO> getOrderByCashier(Long cashierId);
    void deleteOrder(Long Id) throws Exception;
    List<OrderDTO> getTodayOrderByBranch(Long branchId) throws Exception;
    List<OrderDTO> getOrdersByCustomerId(Long customerId) throws Exception;
    List<OrderDTO> getTop5RecentOrderByBranchId(Long branchId) throws Exception;
}
