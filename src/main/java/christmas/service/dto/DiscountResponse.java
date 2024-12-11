package christmas.service.dto;

import christmas.domain.Discount;

public record DiscountResponse(Discount discountType, int discountPrice) {
}
