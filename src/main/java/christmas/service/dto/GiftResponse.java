package christmas.service.dto;

import christmas.domain.Menu;

public record GiftResponse(Menu menu, int count) {
}
