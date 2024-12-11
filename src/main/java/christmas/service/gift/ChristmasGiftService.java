package christmas.service.gift;

import christmas.domain.Discount;
import christmas.domain.Menu;
import christmas.service.dto.GiftResponse;

public class ChristmasGiftService implements GiftService {
    private final Discount DISCOUNT_TYPE = Discount.GIFT;
    private final int STANDARD_COUNT = 120_000;
    private final Menu GIFT = Menu.샴페인;
    private final int GIFT_COUNT = 1;

    @Override
    public GiftResponse getGiftInfo(final int purchaseCount) {
        if (purchaseCount < STANDARD_COUNT) {
            return new GiftResponse(DISCOUNT_TYPE, null, 0);
        }
        return new GiftResponse(DISCOUNT_TYPE, GIFT, GIFT_COUNT);
    }
}
