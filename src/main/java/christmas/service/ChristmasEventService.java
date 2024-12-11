package christmas.service;

import christmas.domain.*;
import christmas.service.discount.*;
import christmas.service.dto.ChristmasEventResponse;
import christmas.service.dto.DiscountResponse;
import christmas.service.dto.GiftResponse;
import christmas.service.gift.ChristmasGiftService;
import christmas.service.gift.GiftService;

import java.util.EnumMap;

public class ChristmasEventService {
    private final int STANDARD_PRICE = 10_000;

    private final EnumMap<Discount, DiscountService> discountServices = new EnumMap<>(Discount.class);
    private final GiftService giftService;

    public ChristmasEventService() {
        discountServices.put(Discount.CHRISTMAS, new ChristmasDiscountService());
        discountServices.put(Discount.SPECIAL, new SpecialDayDiscountService());
        discountServices.put(Discount.WEEKDAY, new WeekdayDiscountService());
        discountServices.put(Discount.WEEKEND, new WeekendDiscountService());
        giftService = new ChristmasGiftService();
    }

    public ChristmasEventResponse apply(DecemberDate date, Order order) {
        EventBenefit eventBenefit = new EventBenefit();
        final int totalPrice = order.getTotalPrice();
        if (!isApplicable(order)) {
            return new ChristmasEventResponse(totalPrice, eventBenefit, null, 0);
        }
        for (Discount type : discountServices.keySet()) {
            DiscountService service = discountServices.get(type);
            DiscountResponse response = service.getDiscountInfo(date, order);
            eventBenefit.setBenefit(type, response.discountPrice());
        }
        GiftResponse response = giftService.getGiftInfo(order.getTotalPrice());
        return new ChristmasEventResponse(totalPrice, eventBenefit, response.menu(), response.count());
    }

    private boolean isApplicable(Order order) {
        return order.getTotalPrice() >= STANDARD_PRICE;
    }
}
