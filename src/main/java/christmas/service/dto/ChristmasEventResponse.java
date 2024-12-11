package christmas.service.dto;

import christmas.domain.Badge;
import christmas.domain.EventBenefit;
import christmas.domain.Menu;

public record ChristmasEventResponse(
        int totalOrderPrice,
        EventBenefit eventBenefit,
        Menu giftMenu,
        int giftCount
) {
    public int totalBenefit() {
        if (giftMenu == null || giftCount == 0) {
            return eventBenefit.getTotalBenefit();
        }
        return eventBenefit.getTotalBenefit() + giftCount * giftMenu.price;
    }

    public Badge badge() {
        return Badge.getBadge(totalBenefit());
    }

    public int creditPrice() {
        return totalOrderPrice - eventBenefit.getTotalBenefit();
    }
}
