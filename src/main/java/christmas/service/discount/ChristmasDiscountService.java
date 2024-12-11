package christmas.service.discount;

import christmas.domain.DecemberDate;
import christmas.domain.Discount;
import christmas.domain.Order;
import christmas.service.dto.DiscountResponse;

public class ChristmasDiscountService implements DiscountService {
    private final Discount discountType = Discount.CHRISTMAS;
    private final int BASE_COUNT = 1000;
    private final int INCREASE_COUNT = 100;
    private final int CHRISTMAS_DATE = 25;

    @Override
    public DiscountResponse getDiscountInfo(DecemberDate date, Order order) {
        if (date.value() > CHRISTMAS_DATE) {
            return new DiscountResponse(discountType, 0);
        }
        return new DiscountResponse(discountType, BASE_COUNT + (date.value() - 1) * INCREASE_COUNT);
    }
}
