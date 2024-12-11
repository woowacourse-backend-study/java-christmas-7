package christmas.service;

import christmas.domain.Order;
import christmas.service.dto.DiscountResponse;

public class ChristmasDiscountService implements DiscountService {
    private final int BASE_COUNT = 1000;
    private final int INCREASE_COUNT = 100;
    private final int CHRISTMAS_DATE = 25;

    @Override
    public DiscountResponse getDiscountInfo(int date, Order order) {
        if (date > CHRISTMAS_DATE) {
            return new DiscountResponse(0);
        }
        return new DiscountResponse(BASE_COUNT + (date - 1) * INCREASE_COUNT);
    }
}
