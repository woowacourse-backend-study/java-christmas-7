package christmas.service;

import christmas.domain.MenuType;
import christmas.domain.Order;
import christmas.domain.Weekend;
import christmas.service.dto.DiscountResponse;

public class WeekdayDiscountService implements DiscountService {
    private final MenuType DISCOUNT_TARGET = MenuType.DESSERT;
    private final int DISCOUNT_PRICE = 2_023;

    @Override
    public DiscountResponse getDiscountInfo(int date, Order order) {
        if (Weekend.isWeekend(date)) {
            return new DiscountResponse(0);
        }
        final int targetCount = order.getMenuCount(DISCOUNT_TARGET);
        return new DiscountResponse(DISCOUNT_PRICE * targetCount);
    }
}
