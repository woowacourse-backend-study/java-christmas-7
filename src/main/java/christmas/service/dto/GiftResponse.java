package christmas.service.dto;

import christmas.domain.Discount;
import christmas.domain.Menu;

public record GiftResponse(Discount discountType, Menu menu, int count) {
}
