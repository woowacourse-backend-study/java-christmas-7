package christmas.service.discount;

import christmas.domain.DecemberDate;
import christmas.domain.Discount;
import christmas.domain.Order;
import christmas.service.dto.DiscountResponse;

public class SpecialDayDiscountService implements DiscountService {
    private final Discount DISCOUNT_TYPE = Discount.SPECIAL;
    private final int DISCOUNT_PRICE = 1_000;

    @Override
    public DiscountResponse getDiscountInfo(DecemberDate date, Order order) {
        if (date.isSpecialDate()) {
            return new DiscountResponse(DISCOUNT_TYPE, DISCOUNT_PRICE);
        }
        return new DiscountResponse(DISCOUNT_TYPE, 0);
    }
}
