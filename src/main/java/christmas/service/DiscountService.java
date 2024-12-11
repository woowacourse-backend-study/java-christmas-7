package christmas.service;

import christmas.domain.Order;
import christmas.service.dto.DiscountResponse;

public interface DiscountService {
    DiscountResponse getDiscountInfo(int date, Order order);
}
