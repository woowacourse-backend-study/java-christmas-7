package christmas.service.discount;

import christmas.domain.DecemberDate;
import christmas.domain.Order;
import christmas.service.dto.DiscountResponse;

public interface DiscountService {
    DiscountResponse getDiscountInfo(DecemberDate date, Order order);
}
