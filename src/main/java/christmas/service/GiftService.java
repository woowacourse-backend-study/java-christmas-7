package christmas.service;

import christmas.service.dto.GiftResponse;

public interface GiftService {
    GiftResponse getGiftInfo(int purchaseCount);
}
