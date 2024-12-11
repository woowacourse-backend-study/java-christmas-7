package christmas.service.discount;

import christmas.domain.DecemberDate;
import christmas.domain.Discount;
import christmas.domain.MenuType;
import christmas.domain.Order;
import christmas.service.dto.DiscountResponse;

public class WeekendDiscountService implements DiscountService {
    private final Discount DISCOUNT_TYPE = Discount.WEEKEND;
    private final MenuType DISCOUNT_TARGET = MenuType.MAIN;
    private final int DISCOUNT_PRICE = 2_023;

    @Override
    public DiscountResponse getDiscountInfo(DecemberDate date, Order order) {
        if (date.isWeekend()) {
            final int targetCount = order.getMenuCount(DISCOUNT_TARGET);
            return new DiscountResponse(DISCOUNT_TYPE, DISCOUNT_PRICE * targetCount);
        }
        return new DiscountResponse(DISCOUNT_TYPE, 0);
    }
}
