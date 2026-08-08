package com.supratim.service.impl;

import com.supratim.mapper.RefundMapper;
import com.supratim.modal.Branch;
import com.supratim.modal.Order;
import com.supratim.modal.Refund;
import com.supratim.modal.User;
import com.supratim.payload.dto.RefundDTO;
import com.supratim.repository.OrderRepository;
import com.supratim.repository.RefundRepository;
import com.supratim.service.RefundService;
import com.supratim.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RefundServiceImpl implements RefundService {

    private final UserService userService;
    private final OrderRepository orderRepository;
    private final RefundRepository refundRepository;


    @Override
    public RefundDTO createRefund(RefundDTO refund) throws Exception {
        User cashier = userService.getCurrentUser();

        Order order= orderRepository.findById(refund.getOrderId()).orElseThrow(
                ()-> new Exception("Order Not Found")
        );

        Branch branch = order.getBranch();

        Refund createdRefund = Refund.builder()
                .order(order)
                .cashier(cashier)
                .branch(branch)
                .reason(refund.getReason())
                .amount(refund.getAmount())
                .createdAt(refund.getCreatedAt())
                .build();
        Refund savedRefund = refundRepository.save(createdRefund);
        return RefundMapper.toDTO(savedRefund);
    }

    @Override
    public List<RefundDTO> getAllRefunds() throws Exception {
        return refundRepository.findAll().stream()
                .map(RefundMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public RefundDTO getRefundByCashier(Long cashierId) throws Exception {
        return null;
    }

    @Override
    public RefundDTO getRefundByShiftReport(Long shiftReportId) throws Exception {
        return null;
    }

    @Override
    public List<RefundDTO> getRefundByCashierAndDateRange(Long cashierId, LocalDateTime startDate, LocalDateTime endDate) throws Exception {
        return List.of();
    }

    @Override
    public List<RefundDTO> getRefundByBranch(Long branchId) throws Exception {
        return List.of();
    }

    @Override
    public RefundDTO getRefundById(Long refundId) throws Exception {
        return null;
    }

    @Override
    public void deleteRefund(Long refundId) throws Exception {

    }
}
