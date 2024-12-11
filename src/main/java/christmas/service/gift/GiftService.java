package christmas.service.gift;

import christmas.service.dto.GiftResponse;

public interface GiftService {
    GiftResponse getGiftInfo(int purchaseCount);
}
