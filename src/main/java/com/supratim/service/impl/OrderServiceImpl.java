package com.supratim.service.impl;

import com.supratim.domain.OrderStatus;
import com.supratim.domain.PaymentType;
import com.supratim.modal.*;
import com.supratim.payload.dto.OrderDTO;
import com.supratim.repository.OrderRepository;
import com.supratim.repository.ProductRepository;
import com.supratim.service.OrderService;
import com.supratim.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final UserService userService;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) throws Exception {
        User cashier = userService.getCurrentUser();

        Branch branch = cashier.getBranch();
        if(branch == null){
            throw new Exception("Cashier's branch not found");
        }

        Order order= Order.builder()
                .branch(branch)
                .cashier(cashier)
                .customer(orderDTO.getCustomer())
                .paymentType(orderDTO.getPaymentType())
                .build();

        List<OrderItem> orderItems = orderDTO.getItems().stream().map(
                itemDTO ->{
                    Product product = productRepository.findById(itemDTO.getProductId()).orElseThrow(
                            ()-> new EntityNotFoundException("Product not found"));

                    return OrderItem.builder()
                            .product(product)
                            .quantity(itemDTO.getQuantity())
                            .price(product.getSellingPrice()*itemDTO.getQuantity())
                            .order(order)
                            .build();
                }
        ).toList();
        double total = orderItems.stream().mapToDouble(
                OrderItem::getPrice
        ).sum();
        order.setTotalAmount(total);
        order.setItems(orderItems);

        Order savedOrder = orderRepository.save(order);
        return null;
    }

    @Override
    public OrderDTO getOrderById(Long Id) throws Exception {
        return null;
    }

    @Override
    public List<OrderDTO> getOrdersByBranch(Long branchId, Long customerId, Long cashierId, PaymentType paymentType, OrderStatus status) throws Exception {
        return List.of();
    }

    @Override
    public List<OrderDTO> getOrderByCashier(Long cashierId) {
        return List.of();
    }

    @Override
    public void deleteOrder(Long Id) throws Exception {

    }

    @Override
    public List<OrderDTO> getTodayOrderByBranch(Long branchId) throws Exception {
        return List.of();
    }

    @Override
    public List<OrderDTO> getOrdersByCustomerId(Long customerId) throws Exception {
        return List.of();
    }

    @Override
    public List<OrderDTO> getTop5RecentOrderByBranchId(Long branchId) throws Exception {
        return List.of();
    }
}
