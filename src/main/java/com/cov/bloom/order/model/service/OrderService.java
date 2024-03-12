package com.cov.bloom.order.model.service;

import com.cov.bloom.order.model.dao.OrderDAO;
import com.cov.bloom.order.model.dto.OptionDTO;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderService {

    private final OrderDAO orderDAO;

    public OrderService(OrderDAO orderDAO){
        this.orderDAO = orderDAO;
    }

    public OptionDTO getOption(Map<String, String> searchOption) {

        OptionDTO option = orderDAO.getOption(searchOption);

        return option;
    }
}
