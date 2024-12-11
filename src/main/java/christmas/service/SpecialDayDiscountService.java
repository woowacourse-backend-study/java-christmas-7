package christmas.service;

import christmas.domain.Order;
import christmas.domain.Special;
import christmas.service.dto.DiscountResponse;

public class SpecialDayDiscountService implements DiscountService {
    private final int DISCOUNT_PRICE = 1_000;

    @Override
    public DiscountResponse getDiscountInfo(int date, Order order) {
        if (Special.isSpecialDay(date)) {
            return new DiscountResponse(DISCOUNT_PRICE);
        }
        return new DiscountResponse(0);
    }
}
